/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Vidya
 */
public class m_model {
    public String PID, SID, SNM, JNS, OPT; 
    public String ID;
    
    public String getID()
    {
        return ID;
    }
    
    public String getPid()
    {
        return PID;
    }
    
    public String getSid()
    {
        return SID;
    }
    
    public String getSnm()
    {
        return SNM;
    }
    
    public String getJns()
    {
        return JNS;
    }
    
    public String getOpt()
    {
        return OPT;
    }
    
    //method set
    
    public void setid(String id)
    {
        this.ID= id;
    }
    public void setpid(String pid)
    {
        this.PID= pid;
    }
    public void setsid(String sid)
    {
        this.SID= sid;
    }
    public void setsnm(String snm)
    {
        this.SNM= snm;
    }
    public void setjns(String jns)
    {
        this.JNS= jns;
    }
    public void setopt(String opt)
    {
        this.OPT= opt;
    }
    
    
}
