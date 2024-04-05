document.addEventListener("DOMContentLoaded", () => {
  const product_body = document.querySelector("tbody.product_body");
  const btn_update = document.querySelector("input.btn_update");
  const btn_delete = document.querySelector("input.btn_delete");

  const product_body_onClick_handler = (e) => {
    const target = e.target;
    if (target.tagName === "TD") {
      const TR = target.closest("TR");
      const seq = TR.dataset.seq;

      document.location.href = `${rootPath}/detail?i_seq=${seq}`;
    }
  }; // 디테일 이동하기 ------------------------

  product_body?.addEventListener(
    "click",
    product_body_onClick_handler
  ); //함수 괄호금지

  // 수정
  btn_update?.addEventListener("click", (e) => {
    const seq = e.target.dataset.seq;
    document.location.href = `${rootPath}/update?i_seq=${seq}`; // input box 이름이랑 달라야함 update?ccode
  });

  // 삭제
  btn_delete.addEventListener("click", (e) => {
    const seq = e.target.dataset.seq;

    if (confirm("거래정보를 삭제하시겠습니까?")) {
      document.location.replace(`${rootPath}/delete/${seq}`);
    }
  });
});
