document.addEventListener("DOMContentLoaded", () => {
  const fileInput = document.querySelector("input.file.single");
  const filesInput = document.querySelector("input.file.multi");

  const prevImg = document.querySelector("img.gallery");
  const imgBorderBox = document.querySelector("div.image");
  const base64Box = document.querySelector("textarea.base64");
  const multiImageBox = document.querySelector("div.image.multi");

  const ecodeImageFileAsBase64 = async (image) => {
    return new Promise((resolve, _) => {
      const reader = new FileReader(); // await 안되는 함수
      reader.onloadend = () => {
        resolve(reader.result);
      };
      reader.readAsDataURL(image);
    });
  };

  prevImg.addEventListener("click", () => filesInput.click());

  // 이미지 붙여넣기
  imgBorderBox.addEventListener("paste", async (e) => {
    const items = e.clipboardData.items;
    // items 객체가 존재하면 그중 0번째 요소를 getter 하기
    const item = items?.[0]; // 클립보드가 비었을 수도 있어서
    // image/png, text/plan, application/text

    // 붙여넣기 한 데이터가 image/* 이면~~
    if (item.type.indexOf("image") === 0) {
      // 붙여넣기 한 이미지 중에서 파일만 추출하기
      const blob = item.getAsFile();
      console.log(blob);
      // 파일이 추출이 안되면
      if (!blob) {
        return null;
      }
      const base64 = await ecodeImageFileAsBase64(blob);
      prevImg.src = base64;
      base64Box.value = base64;
      //   // 파일을 읽기 위한 도구(클래스)
      //   const reader = new FileReader();
      //   // 파일이 모두 load(읽히기) 되었으면
      //   reader.onloadend = () => {
      //     prevImg.src = reader.result;
      //   };
      //   // 파일을 읽어라 라는 명령
      //   reader.readAsDataURL(blob); // file 리더로 blob로 된 파일을 읽어라 다읽으면 onloadend 이벤트발생
    } else {
      alert("이미지만 붙여 넣기 하세요");
    }
  });

  const filePreView = async (file) => {
    const base64 = await ecodeImageFileAsBase64(file);
    if (base64) {
      const img = document.createElement("img");
      img.style.width = "100px";
      img.src = base64;
      multiImageBox.appendChild(img);
    }
  };

  filesInput.addEventListener("change", async (e) => {
    const files = e.target.files;
    multiImageBox.innerHTML = ""; // 프리뷰 계속추가되는 것 방지
    for (let file of files) {
      await filePreView(file);
    }
  });

  fileInput.addEventListener("change", async (e) => {
    // 이미지 파일의 미리보기
    // const files = target.files;
    // if (target.files.length > 1) {
    // }
    const target = e.target;
    const file = target.files[0];
    await filePreView(file);
    // const base64 = await ecodeImageFileAsBase64(file);
    // prevImg.src = base64;
    // base64Box.value = base64;
  });
});
