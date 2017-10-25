/*
 * Author:Chandan Shanbhag
 * 
 * 
 */
package watchtower;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNLogEntry;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.fs.FSRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

/**
 *
 * @author chandan.shanbhag
 */
public class getsvn {
    
    final String name = "bar.platform";
  final String password = "Oct@2015";
  
  public void getLog(String svnurl, long startVersion, long endVersion)
    throws IOException
  {
    String url = svnurl;
    long startRevision = startVersion;
    long endRevision = endVersion;
    
    System.out.println(" Starting version and end version is " + startRevision);
    
    System.out.println(" Ending version and end version is " + endRevision);
    
    File file = new File("SVNLog.txt");
    FileOutputStream fis = null;
    try
    {
      fis = new FileOutputStream(file);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    PrintStream out = new PrintStream(fis);
    System.setOut(out);
    setupLibrary();
    SVNRepository repository = null;
    try
    {
      repository = SVNRepositoryFactory.create(SVNURL.parseURIEncoded(url));
    }
    catch (SVNException svne)
    {
      System.err.println("error while creating an SVNRepository for the location '" + url + "': " + svne.getMessage());
      
      System.exit(1);
    }
    ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager("bar.platform", "Oct@2015");
    
    repository.setAuthenticationManager(authManager);
    
    Collection logEntries = null;
    try
    {
      logEntries = repository.log(new String[] { "" }, null, startRevision, endRevision, true, true);
    }
    catch (SVNException svne)
    {
      System.out.println("error while collecting log information for '" + url + "': " + svne.getMessage());
      
      System.exit(1);
    }
    try
    {
      for (Iterator entries = logEntries.iterator(); entries.hasNext();)
      {
        SVNLogEntry logEntry = (SVNLogEntry)entries.next();
        
        System.out.println("log message: " + logEntry.getMessage());
      }
      fis.flush();
      fis.close();
      fis = null;
      System.gc();
      
      System.out.println("----------------------------");
        Scanner scanner = new Scanner(file);
    }
    finally
    {
      Scanner scanner;
      file.delete();
    }
  }
  
  public long getEndVersion(String svnurl, long endversion)
  {
    String url = svnurl;
    SVNRepository repository = null;
    try
    {
      repository = SVNRepositoryFactory.create(SVNURL.parseURIEncoded(url));
    }
    catch (SVNException svne)
    {
      System.err.println("error while creating an SVNRepository for the location '" + url + "': " + svne.getMessage());
      
      System.exit(1);
    }
    ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager("bar.platform", "Oct@2015");
    
    repository.setAuthenticationManager(authManager);
    try
    {
      endversion = repository.getLatestRevision();
    }
    catch (SVNException svne)
    {
      System.err.println("error while fetching the latest repository revision: " + svne.getMessage());
      
      System.exit(1);
    }
    return endversion;
  }
  
  private static void setupLibrary()
  {
    DAVRepositoryFactory.setup();
    SVNRepositoryFactoryImpl.setup();
    FSRepositoryFactory.setup();
  
  }
    
    
    
}
