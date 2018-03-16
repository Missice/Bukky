package me.HibernateModel;

import me.model.CyclePointInfoDbEntity;
import net.sf.json.JSON;

import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.UUID;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.hibernate.Session;
import org.hibernate.query.Query;

import me.model.*;




public class HibernateModel implements Model{
    Session session = null;
    @Override
    public void CyclePointInfoCreate(String CycleUserID,String CycleStartDate,JSONArray CyclePointMessage){
        try{
            session = HibernateUtils.getSession();
            session.beginTransaction();
            CyclePointInfoDbEntity cyclePointinfo= new CyclePointInfoDbEntity();
            cyclePointinfo.setCycleUserId(CycleUserID);
            cyclePointinfo.setCycleStartDate(CycleStartDate);
            cyclePointinfo.setCyclePointMessage(CyclePointMessage.toString());
            cyclePointinfo.setFlag((byte)1);
            session.saveOrUpdate(cyclePointinfo);
            session.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
    }finally {
        HibernateUtils.closeSession();
    }
    }

    @Override
    public CyclePointInfo CyclePointInfoGet(String CycleUserID, String CycleStartDate ) {
        List<CyclePointInfoDbEntity> CyclePointList=null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();
            Query query = session.createQuery("from CyclePointInfoDbEntity c where c.cycleUserId=? and c.cycleStartDate=? ");
            query.setParameter(0, CycleUserID);
            query.setParameter(1, CycleStartDate);
            CyclePointList = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtils.closeSession();
        }
        if(CyclePointList.isEmpty()){
            return null;
        }else{
            if(CyclePointList.get(0).getFlag()==(byte)0)
                return null;
            CyclePointInfo temp= new CyclePointInfo(CycleUserID,CycleStartDate,JSONArray.fromObject(CyclePointList.get(0).getCyclePointMessage()));
            return temp;
        }
    }


    @Override
    public void CyclePointInfoDelete(String CycleUserID, String CycleStartDate){
        List<CyclePointInfoDbEntity> CyclePointList=null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();
            Query query = session.createQuery("from CyclePointInfoDbEntity c where c.cycleUserId=? and c.cycleStartDate=? ");
            query.setParameter(0, CycleUserID);
            query.setParameter(1, CycleStartDate);
            CyclePointList = query.getResultList();
            for(int i=0;i<CyclePointList.size();i++){
                CyclePointList.get(i).setFlag((byte)0);//直接做标记，假删
                session.update(CyclePointList.get(i));
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtils.closeSession();
        }
    }
    @Override
    public void CycleGroupingSituationCreate(String id,String CycleStartDate,JSONArray GroupMessage){
        try{
            session = HibernateUtils.getSession();
            session.beginTransaction();
            CycleGroupingSituationDbEntity GroupingsituationInfo= new CycleGroupingSituationDbEntity();
            GroupingsituationInfo.setCycleUserId(id);
            GroupingsituationInfo.setGroupMessages(GroupMessage.toString());
            GroupingsituationInfo.setFlag((byte)1);
            GroupingsituationInfo.setCycleStartDate(CycleStartDate);
            session.saveOrUpdate(GroupingsituationInfo);
            session.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            HibernateUtils.closeSession();
        }
    }


    @Override
    public List<CycleGroupingSituation> CycleGroupingSituationGet(String CycleUserID){
        List<CycleGroupingSituationDbEntity> CycleGroubEntityList=null;
        List<CycleGroupingSituation> CycleGroupingSituationList= new ArrayList<CycleGroupingSituation>();
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();
            Query query = session.createQuery("from CycleGroupingSituationDbEntity c where c.cycleUserId=?");
            query.setParameter(0, CycleUserID);
            CycleGroubEntityList = query.getResultList();
            for(int i=0;i<CycleGroubEntityList.size();i++){
                if(CycleGroubEntityList.get(i).getFlag()==(byte)0){
                    continue;
                }
                CycleGroupingSituationList.add(new CycleGroupingSituation(CycleGroubEntityList.get(i).getCycleUserId(),CycleGroubEntityList.get(i).getCycleStartDate(),JSONArray.fromObject(CycleGroubEntityList.get(i).getGroupMessages())));
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtils.closeSession();
            return CycleGroupingSituationList;
        }
    }

    @Override
    public void CycleGroupingSituationDelete(String CycleUserID, String CycleStartDate){
        List<CycleGroupingSituationDbEntity> CycleGoudingList=null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();
            Query query = session.createQuery("from CycleGroupingSituationDbEntity c where c.cycleUserId=? and c.cycleStartDate=? ");
            query.setParameter(0, CycleUserID);
            query.setParameter(1, CycleStartDate);
            CycleGoudingList = query.getResultList();
            for(int i=0;i<CycleGoudingList.size();i++){
                CycleGoudingList.get(i).setFlag((byte)0);//直接做标记，假删
                session.update(CycleGoudingList.get(i));
            }
            session.getTransaction().commit();
            CyclePointInfoDelete(CycleUserID,CycleStartDate);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtils.closeSession();
        }
    }
    @Override
    public  CycleUserInfo CycleUserInfoGetUserID(String CyclelogInType,String CycleLogInID,JSON Messages){
        CycleUserInfo temp=null;
        List<CycleUserInfoDbEntity> CycleUserList=null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();
            Query query = session.createQuery("from CycleUserInfoDbEntity c where c.cycleLogInId=? and c.cycleLogInType=?");
            query.setParameter(0,CycleLogInID);
            query.setParameter(1,CyclelogInType);
            CycleUserList = query.getResultList();
            if(!CycleUserList.isEmpty()){
                if(CycleUserList.get(0).getFlag()==(byte)0) {
                    CycleUserList.get(0).setFlag((byte) 1);
                }
                session.update(CycleUserList.get(0));
                session.getTransaction().commit();
                temp= new CycleUserInfo(CycleUserList.get(0).getCycleUserId(),CycleUserList.get(0).getCycleLogInType(),CycleUserList.get(0).getCycleLogInId(),JSONObject.fromObject(CycleUserList.get(0).getCyceleUserMessage()));
            }else {
                CycleUserInfoDbEntity newCreateUser= new CycleUserInfoDbEntity();
                newCreateUser.setCycleUserId(UUID.randomUUID().toString());
                newCreateUser.setFlag(((byte)1));
                newCreateUser.setCycleLogInId(CycleLogInID);
                newCreateUser.setCycleLogInType(CyclelogInType);
                System.out.println(Messages.toString());
                newCreateUser.setCyceleUserMessage(Messages.toString());
                System.out.println(newCreateUser.toString());
                temp=new CycleUserInfo(newCreateUser.getCycleUserId(),CyclelogInType,CycleLogInID,Messages);
                session.save(newCreateUser);
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtils.closeSession();
            return temp;
        }
    }
    @Override
    public CycleUserInfo CycleUserInfoGetUserMessage(String CycleUserID){//以UserID来获取微博用户的信息
        CycleUserInfo temp=null;
        List<CycleUserInfoDbEntity> CycleUserList=null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();
            Query query = session.createQuery("from CycleUserInfoDbEntity c where c.cycleUserId=?");
            query.setParameter(0, CycleUserID);
            CycleUserList = query.getResultList();
            session.getTransaction().commit();
            if(CycleUserList.get(0).getFlag()==(byte)1) {
                temp=new CycleUserInfo(CycleUserList.get(0).getCycleUserId(), CycleUserList.get(0).getCycleLogInType(), CycleUserList.get(0).getCycleLogInId(), JSONObject.fromObject(CycleUserList.get(0).getCyceleUserMessage()));
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtils.closeSession();
            return temp;
        }
    }
    @Override
    public void CycleAddLike(String CycleUserID,String CyclelikeID){
        List <CycleFanDbEntity> fanEntity=null;
        try{
            session = HibernateUtils.getSession();
            session.beginTransaction();
            Query query = session.createQuery("from CycleFanDbEntity c where c.cycleUserId=?and c.cycleLikeId=?");
            query.setParameter(0,CycleUserID);
            query.setParameter(1,CyclelikeID);
            fanEntity = query.getResultList();
            if(fanEntity.isEmpty()){
                CycleFanDbEntity fanTemp=new CycleFanDbEntity();
                fanTemp.setFlag((byte)1);
                fanTemp.setCycleUserId(CycleUserID);
                fanTemp.setCycleLikeId(CyclelikeID);
                session.save(fanTemp);
            }else{
                fanEntity.get(0).setFlag((byte)1);
                session.update(fanEntity.get(0));
            }
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtils.closeSession();
        }
    }
    @Override
    public void CycleDelLike(String CycleUserID, String CyclelikeID){
        List <CycleFanDbEntity> fanEntity=null;
        try{
            session = HibernateUtils.getSession();
            session.beginTransaction();
            Query query = session.createQuery("from CycleFanDbEntity c where c.cycleUserId=?and c.cycleLikeId=?");
            query.setParameter(0,CycleUserID);
            query.setParameter(1,CyclelikeID);
            fanEntity = query.getResultList();
            for(int i=0;i<fanEntity.size();i++){
                fanEntity.get(i).setFlag((byte)0);
            }
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtils.closeSession();
        }
    }

    @Override
    public List<CycleKeyEntity> CycleGetAccessToken(String CycleUserID) {
        List <CycleKeyEntity> keyEntityList=null;
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        String dateString = formatter.format(currentTime);
        try{
            session = HibernateUtils.getSession();
            session.beginTransaction();
            Query query = session.createQuery("from CycleKeyEntity c where c.cycleUserId=?");
            query.setParameter(0,CycleUserID);
            keyEntityList = query.getResultList();
            CycleKeyEntity temp=new CycleKeyEntity();
            if(keyEntityList.isEmpty()){
                temp.setCycleUserId(CycleUserID);
                temp.setCycleAccessTokenTime(dateString);
                temp.setAccessToken(UUID.randomUUID().toString());
                keyEntityList.add(temp);
                session.save(temp);
            }else{
                if(!dateString.equals(keyEntityList.get(0).getCycleAccessTokenTime())){
                    keyEntityList.get(0).setAccessToken(UUID.randomUUID().toString());
                    keyEntityList.get(0).setCycleAccessTokenTime(dateString);
                    session.save( keyEntityList.get(0));
                }
            }
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtils.closeSession();
            return keyEntityList;
        }
    }

    @Override
    public boolean CycleIsAccessToken(String AccessToken) {
        List<CycleKeyEntity> keyEntityList = null;
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        String dateString = formatter.format(currentTime);
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();
            Query query = session.createQuery("from CycleKeyEntity c where c.accessToken=?");
            query.setParameter(0, AccessToken);
            keyEntityList = query.getResultList();
            session.getTransaction().commit();
            HibernateUtils.closeSession();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        if(keyEntityList.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public List <String> CycleGetLike(String CycleUserID){
        List <CycleFanDbEntity> fanEntity=null;
        List <String> temp=new ArrayList<String>();
        try{
            session = HibernateUtils.getSession();
            session.beginTransaction();
            Query query = session.createQuery("from CycleFanDbEntity c where c.cycleUserId=?");
            query.setParameter(0,CycleUserID);
            fanEntity = query.getResultList();
            for(int i=0;i<fanEntity.size();i++){
                if(fanEntity.get(i).getFlag()==(byte)0){
                    continue;
                }
                    temp.add(fanEntity.get(i).getCycleLikeId());

            }
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtils.closeSession();
        }
        return temp;
    }
    @Override
    public List <String> CycleGetFan(String CycleLikeID){
        List <CycleFanDbEntity> fanEntity=null;
        List <String> temp=new ArrayList<String>();
        try{
            session = HibernateUtils.getSession();
            session.beginTransaction();
            Query query = session.createQuery("from CycleFanDbEntity c where c.cycleLikeId=?");
            query.setParameter(0,CycleLikeID);
            fanEntity = query.getResultList();
            for(int i=0;i<fanEntity.size();i++){
                if(fanEntity.get(i).getFlag()==(byte)0){
                    continue;
                }
                temp.add(fanEntity.get(i).getCycleUserId());

            }
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtils.closeSession();
        }
        return temp;
    }

}
