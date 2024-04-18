document.addEventListener("DOMContentLoaded", () => {
  const join_form = document.querySelector("form.join");

  const username = join_form.querySelector("input[name='username']");
  const password = join_form.querySelector("input[name='password']");
  const re_password = join_form.querySelector(
    "input[name='re_password']"
  );
  const btn_join = join_form.querySelector("button");

  // 정규식 문법 https://github.com/callor/Reference/blob/master/MarkDownDocs/JS%EC%A0%95%EA%B7%9C%EC%8B%9D.md
  // userNameExp 은 영대소문자와 언더바(_) 를 사용할 수 있으며 4~20 글자까지 가능
  const userNameExp = /^[a-zA-Z0-9]{4,20}$/;
  const passwordExp = /^[a-zA-Z0-9!@#$%^&*()]{8,20}$/; // password 는 영문자 대소문자포함해서, 특수문자도 포함할 수 있다
  const idCheck = async (username) => {
    try {
      // fetch로 res결과받기
      const res = await fetch(`${rootPath}/user/idcheck/${username}`);
      // const json = await res.json(); // Server 가 JSON type 의 데이터를 보낼때
      const result = await res.text(); // 문자열로 보냈으니 text로 받는다 (유저컨트롤러의 if(userVO == null) return "OK"; )
      return result === "OK"; // true, false 됨 - 아래의 if문에서 if(true , false)
    } catch (error) {
      alert("서버와 통신 오류");
    }
  };

  btn_join.addEventListener("click", async () => {
    if (!username.value) {
      alert("USERNAME 은 반드시 입력하세요");
      username.select();
      return false;
    }
    // 값이 규칙에 안맞으면
    if (!userNameExp.test(username.value)) {
      alert(
        "USERNAME 은 영문 대소문자, 숫자 _로 4~20글자만 가능합니다"
      );
      username.select();
      return false;
    }

    // 사용할수없으면
    // idcheck 가 async 여서 여기서 받을때 await
    if (!(await idCheck(username.value))) {
      alert("이미 가입된 USERNAME 입니다");
      username.select();
      return false;
    }

    if (!password.value) {
      alert("PASSWORD 은 반드시 입력하세요");
      password.select();
      return false;
    }

    if (!passwordExp.test(password.value)) {
      alert(
        "비밀번호는 8자리 이상 영문, 숫자, 특수문자 만 가능합니다"
      );
      password.select();
      return false;
    }

    if (!re_password.value) {
      alert("패스워드 확인은 반드시 입력하세요");
      re_password.select();
      return false;
    }
    if (password.value != re_password.value) {
      alert("비밀번호와 비밀번호 확인이 일치하지 않습니다");
      password.select();
      return false;
    }
    // form의 전송 실행하기
    join_form.submit();
  });
});
