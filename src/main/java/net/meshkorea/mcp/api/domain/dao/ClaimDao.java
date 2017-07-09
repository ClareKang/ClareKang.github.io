package net.meshkorea.mcp.api.domain.dao;

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

    public List<ClaimList> findClaims(ClaimSearchDto claimSearchDto) {
        List<ClaimList> list = sqlSession.selectList(namespace + "findClaims", claimSearchDto);
        return list;
    }

    public int createClaim(CreateClaimRequest req) {
        int claimNo = sqlSession.insert(namespace + "createClaim", req);
        return claimNo;
    }

    public ClaimOrderRelationDto getClaimOrderRelation(int claimNo) {
        return sqlSession.selectOne(namespace + "getClaimOrderRelation", claimNo);
    }

    public List<ClaimHistory> getClaimHistory(Long claimNo) {
        return sqlSession.selectList(namespace + "getClaimHistory", claimNo);
    }

    public List<ClaimAdjustmentHistory> getClaimAdjustmentHistory(Long claimNo) {
        return sqlSession.selectList(namespace + "getClaimAdjustmentHistory", claimNo);
    }

    public int createOrderClaimRelation(CreateClaimRequest req) {
        return sqlSession.insert(namespace + "createOrderClaimRelation", req);
    }

    public int updateClaim(UpdateClaimRequest req) {
        return sqlSession.update(namespace + "updateClaim", req);
    }
    public int updateOrderClaimRelation(UpdateClaimRequest request) {
        return sqlSession.update(namespace + "updateOrderClaimRelation", request);
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

    public int insertClaimHistory(ClaimHistory history) {
        return sqlSession.insert(namespace + "insertClaimHistory", history);
    }

    public int updateDescription(UpdateClaimDescriptionRequest request) {
        return sqlSession.update(namespace + "updateClaimDescription", request);
    }

    public int createClaimAdjustment(CreateClaimAdjustmentRequest request) {
        return sqlSession.insert(namespace + "createClaimAdjustment", request);
    }

    public int insertAdjustmentHistory(ClaimAdjustmentHistory history) {
        return sqlSession.insert(namespace + "createAdjustmentHistory", history);
    }

    public int updateClaimAdjustment(UpdateClaimAdjustmentRequest request) {
        return sqlSession.update(namespace + "updateClaimAdjustment", request);
    }

    public List<ClaimReasonCode> getClaimReasonCode() {
        return sqlSession.selectList(namespace + "getClaimReasonCode");
    }

    public List<ClaimCode> getClaimCode(String code) {
        return sqlSession.selectList(namespace + "getClaimCode", code);
    }
}
