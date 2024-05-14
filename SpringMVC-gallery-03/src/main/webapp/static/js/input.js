document.addEventListener("DOMContentLoaded", () => {
  const preImg = document.querySelector("img.represent");
  const imageInput = document.querySelector("#files");
  const thumnailBox = document.querySelector("div.thumnail");

  // 대표이미지를 클릭하면 input[type='file']를 활성화(click 한 것처럼) 하라
  preImg.addEventListener("click", () => imageInput.click());

  // 함수 만들어서 분리하기
  const imgPreview = (file, target) => {
    const reader = new FileReader();
    reader.onloadend = (e) => (target.src = e.target.result);
    reader.readAsDataURL(file);
  };

  imageInput.addEventListener("change", (e) => {
    const files = e.target.files;
    const file = files[0];
    // 싱글이미지
    imgPreview(file, preImg);

    thumnailBox.innerHTML = ""; // 계속 추가되는 것 방지
    for (let i = 0; i < files.length; i++) {
      const tempImage = document.createElement("img");
      imgPreview(files[i], tempImage);
      thumnailBox.appendChild(tempImage);
    }
  });

  // 클릭한 사진을 썸네일로(미리보기만)
  thumnailBox.addEventListener("click", (e) => {
    const thumImage = e.target;
    preImg.src = thumImage.src;
  });
});
