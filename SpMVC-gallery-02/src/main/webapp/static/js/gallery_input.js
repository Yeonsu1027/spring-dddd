document.addEventListener("DOMContentLoaded", () => {
  const fileInput = document.querySelector("input.file");
  const prevImg = document.querySelector("img.gallery");
  const imgBorderBox = document.querySelector("div.image");
  const base64Box = document.querySelector("textarea.base64");

  /**
   * 업로드 할 "이미지"를 base64 방식으로 encoding 하는 함수
   * base64 제약 사항
   * 파일크기가 상당히 크다
   * jpeg 는 그래도 다소 양호하나 png 나 백터타입 파일은 여러가지 이슈가 있다
   * 파일의 크기문제로 업로드, DB 저장등에서 문제를 일으킬 수 있다.
   * 다만, DB 에 파일을 저장함으로써 별도의 이미지를 보관하는 방식에 비해 다소 유리한 점도 있다.
   *
   * base64 로 변환된 파일을 압축하여, jpg 로 변환하면 용량문제를 다소 해결할 수 있다
   *
   *
   */

  // 비동기식으로 작동되는 도구
  const ecodeImageFileAsBase64 = async (image) => {
    return new Promise((resolve, _) => {
      const reader = new FileReader(); // await 안되는 함수
      reader.onloadend = () => {
        // 읽어지면
        const myImage = new Image();
        const imageBase64 = reader.result;

        myImage.src = imageBase64;
        myImage.onload = (e) => {
          /**
           * Image 객체( myImage ) 에 이미지가 load 되면
           * 화면에 2d 가상 canvas 를 생성하고
           * 그 canvas 에 myImage 에 담긴 이미지를 그려라
           */
          const myCanvas = document.createElement("canvas"); // 화면에 나타나지 않는 가상의 태그 생성
          const context = myCanvas.getContext("2d"); // 가상 캔버스를 만들어서 거기에 2d 이미지를 표현하겠다

          // 그려줄 이미지 크기만큼 canvas 크기 지정하기
          myCanvas.width = e.target.width;
          myCanvas.height = e.target.height;
          context.drawImage(e.target, 0, 0);

          // canvas 에 그려진 이미지를 jpeg 로 변환하고 크기를 0.5배 : 압축(이미지 크기를 줄여서)
          let point = 0.5;
          let reSizeImage = myCanvas.toDataURL("image/jpeg", point);
          const imageSize = 2 * 1024 * 1024; // 2MByte
          // 2MByte 보다 크면 이미지를 0.01배씩 줄이기
          // 압축한 이미지 크기가 2M 보다 크면 계속 일정 비율만큼 압축 실행하기
          while (reSizeImage.length > imageSize) {
            if (point < 0.001) {
              break; // 이미지 올리는걸 포기
            }
            point -= 0.001;
            reSizeImage = myCanvas.toDataURL("image/jpeg", point);
          }
          if (reSizeImage.length > imageSize) {
            alert("이미지가 너무 큽니다 업로드 할 수 없습니다");
            return false;
          }

          resolve(reSizeImage); // 최대 4MByte까지
        };
      };
      reader.readAsDataURL(image);
    });
  };

  prevImg.addEventListener("click", () => fileInput.click());

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

  fileInput.addEventListener("change", async (e) => {
    const target = e.target;
    const file = target.files[0];
    const base64 = await ecodeImageFileAsBase64(file);
    prevImg.src = base64;
    base64Box.value = base64;

    // const reader = new FileReader();

    // reader.onloadend = () => {
    //   prevImg.src = reader.result;
    // };
    // reader.readAsDataURL(file);
  });
});
