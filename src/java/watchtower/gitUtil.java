/*
 * Author:Chandan Shanbhag
 * 
 * 
 */
package watchtower;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ReflogCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.ReflogEntry;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.revwalk.filter.RevFilter;
import org.eclipse.jgit.transport.FetchResult;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

/**
 *
 * @author chandan.shanbhag
 */
public class gitUtil  {
    
    private static final String PLATFORM_REPO="http://msgit.metricstream.com/platform/Platform7.git";
    File LOCAL_REPO=new File("GIT_Platform7");
    private static final String USER_NAME="bar.platform";
    private static final String PASSWORD="Oct@2015";
    BufferedWriter output = null;
    

    
    
    public UsernamePasswordCredentialsProvider setCredentials(){
        UsernamePasswordCredentialsProvider cp=new UsernamePasswordCredentialsProvider(USER_NAME, PASSWORD);
        return cp;
    }
    
   
    public void createOrUpdateRepo() throws IOException, GitAPIException{
    
         if(LOCAL_REPO.exists()){
             System.out.println("Pulling Latest Remote Copy.......");
             FetchResult fetch=Git.open(LOCAL_REPO).fetch().setCredentialsProvider(setCredentials()).call();
         }else{
             System.out.println("Clonning Repo......");
             Git git=Git.cloneRepository().setURI(PLATFORM_REPO).setCredentialsProvider(setCredentials()).setGitDir(LOCAL_REPO).setCloneAllBranches(true).call();
         }
    }
    
    public List<String> getBranches() throws IOException, GitAPIException{
       createOrUpdateRepo();
       Git git=Git.open(LOCAL_REPO);
       Collection<Ref>r=git.lsRemote().setHeads(true).setTags(true).setCredentialsProvider(setCredentials()).call();
       System.out.println();
        List<String> tags=new ArrayList<String>();
           for(Ref reference:r){
               String  temp=reference.getName().toString();
               //System.out.println(temp.substring(temp.lastIndexOf("/") + 1));
               String[] one=temp.split("/");
               tags.add(one[2]);
           }
       git.close();
       return tags;
    }
    
    
    public void getBranchLog(String branchname) throws IOException, GitAPIException{
    createOrUpdateRepo();
    BufferedWriter output = null;
    Git git=Git.open(LOCAL_REPO); 
    output=new BufferedWriter(new FileWriter("GitLog.txt"));
    Repository repo=new FileRepository(LOCAL_REPO+"/.git");
        
   Iterable<RevCommit> logs=git.log()
           .not(repo.resolve("master"))
           .not(repo.resolve("head"))
           .add(repo.resolve("remotes/origin/"+branchname)).call();
    
//    RevWalk walk = new RevWalk(repo);
//    walk.setRevFilter(RevFilter.NO_MERGES);
//    ObjectId from = repo.resolve("master");
//    ObjectId to = repo.resolve("remotes/origin/"+branchname);
//    walk.markStart(walk.parseCommit(to));
//    walk.markUninteresting(walk.parseCommit(from));

    
    
    
     for (Iterator<RevCommit> iterator = logs.iterator(); iterator.hasNext();) {
           RevCommit rev = iterator.next();
           System.out.println(rev.getFullMessage());
           output.write(rev.getFullMessage());
    }
        

     git.close();
     output.close(); 
}
 
    
    public static void main(String args[]) throws IOException, GitAPIException{
    gitUtil g=new gitUtil();
    //g.getBranches();
    g.getBranchLog("AP-5292");
    
    }

}
