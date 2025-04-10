package org.example.simpleboard.model;

import lombok.RequiredArgsConstructor;
import org.example.simpleboard.dto.MemberDTO;
import org.example.simpleboard.mapper.MemberMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl  implements MemberService{
    private final MemberMapper memberMapper;
    @Override
    public void join(MemberDTO memberDTO) {
        memberMapper.join(memberDTO);
    }

    @Override
    public int idCheck(String id) {
        return memberMapper.idCheck(id);
    }

    @Override
    public MemberDTO loginCheck(String id) {
        return memberMapper.loginCheck(id);
    }

    @Override
    public void update(MemberDTO memberDTO) {
        memberMapper.update(memberDTO);
    }
}
