package kr.eddi.demo.member.entity.service;


import kr.eddi.demo.member.entity.service.member.request.MemberSignInRequest;
import kr.eddi.demo.member.entity.service.member.request.MemberSignUpRequest;

public interface MemberService {

    Boolean emailValidation(String email);

    Boolean nickNameValidation (String nickName);

    Boolean signUp(MemberSignUpRequest signUpRequest);

    String signIn(MemberSignInRequest signInRequest);



}