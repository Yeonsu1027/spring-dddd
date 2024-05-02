// document.addEventListener("DOMContentLoaded", function () {
//   // LEVEL4의 fade-in 애니메이션 종료 후 처리
//   document
//     .getElementById("LEVEL4")
//     .addEventListener("animationend", function () {
//       // YS_picture_c 클래스를 가진 모든 이미지에 next_level 클래스 추가
//       var images = document.querySelectorAll(".YS_picture_c");
//       images.forEach(function (image) {
//         image.classList.add("next_level");
//       });
//     });
// });

// document.addEventListener("DOMContentLoaded", () => {
//   const test = document.querySelector(".YS_diary_row");

//   test.addEventListener("click", () => {
//     alert("js 동작테스트");
//   });
// });

// document.addEventListener("DOMContentLoaded", function () {
//   // next_level5 클래스를 가진 이미지 클릭 시 이벤트 처리
//   var nextLevelImages = document.querySelectorAll(".next_level5");
//   nextLevelImages.forEach(function (image) {
//     image.addEventListener("click", function () {
//       // ex-mark 섹션의 hidden 클래스 제거
//       var exMarkSection = document.querySelector(".ex-mark");
//       exMarkSection.classList.remove("hidden");
//     });
//   });
// });

// document.addEventListener("DOMContentLoaded", () => {
//   const clear_level4 = document.querySelector(".next_level5");

//   clear_level4.addEventListener("click", () => {
//     const ex_mark_img = document.querySelector(".ex-mark");
//     ex_mark_img.classList.remove("hidden");
//   });
// });
