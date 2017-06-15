package net.meshkorea.mcp.api.dao;

import net.meshkorea.mcp.api.domain.model.claim.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sungjae.hong on 2017. 6. 14..
 */
@Repository
public class ClaimDao {

    @Autowired
    @Qualifier("masterSqlSessionTemplate")
    private SqlSession sqlSession;
    private String namespace = "ClaimMapper.";

    public Integer test() {
        return sqlSession.selectOne(namespace + "test");
    }

    public List<ClaimRes> findClaims(ClaimSearchDto claimSearchDto) {
        List<ClaimRes> list = sqlSession.selectList(namespace + "findClaims");
        System.out.println(list);
        return list;
    }

    public int createClaim(CreateClaimReq req) {
        int claimNo = sqlSession.insert(namespace+"createClaim", req);
        return claimNo;
    }

    public ClaimOrderRelationDto getClaimOrderRelation(int claimNo) {
        return sqlSession.selectOne(namespace + "getClaimOrderRelation", claimNo);
    }

    public int createOrderClaimRelation(CreateClaimReq req) {
        return sqlSession.insert(namespace + "createOrderClaimRelation", req);
    }

    public int updateClaim(UpdateClaimReq req) {
        return sqlSession.update(namespace + "updateClaim", req);
    }

    public Claim getClaimDetail(Long id) {
        return sqlSession.selectOne(namespace + "getClaimDetail", id);
    }

    public List<ClaimDescriptionDto> getClaimDescription(Long id) {
        return sqlSession.selectList(namespace + "getClaimDescription", id);
    }

    public ClaimAdjustment getClaimAdjustment(Long claimNo) {
        return sqlSession.selectOne(namespace + "getClaimAdjustment", claimNo);
    }
}
