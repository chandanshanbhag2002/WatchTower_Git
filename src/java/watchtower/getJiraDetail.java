/*
 * Author:Chandan Shanbhag
 * 
 * 
 */
package watchtower;


import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import com.jayway.restassured.RestAssured;
import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.builder.RequestSpecBuilder;


import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;



/**
 *
 * @author chandan.shanbhag
 */
public class getJiraDetail {
    
    public  static  List getdetails(List<String> id)  {
        List<bugList> buglist=new LinkedList();
      
       
        String accept="text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8";
        String cookie="__utma=251861909.1166942836.1491283592.1491283592.1493380597.2; __utmz=251861909.1493380597.2.2.utmcsr=id.atlassian.com|utmccn=(referral)|utmcmd=referral|utmcct=/; cloud.session.token=eyJraWQiOiJzZXNzaW9uLXNlcnZpY2VcL3Nlc3Npb24tc2VydmljZSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI1NTcwNTg6MDViODJjN2MtNDA5NC00OGU5LThiOTMtNjk0ZWNmNmMxNzVkIiwiYXVkIjoiYXRsYXNzaWFuIiwiaW1wZXJzb25hdGlvbiI6W10sIm5iZiI6MTQ5MzM4MDU4NiwicmVmcmVzaFRpbWVvdXQiOjE0OTMzODExODYsImlzcyI6InNlc3Npb24tc2VydmljZSIsInNlc3Npb25JZCI6ImJkNmRkZDdiLWU1MWQtNGIxNy1iYjIzLWQyMjA2YzNlMTg5NCIsImV4cCI6MTQ5NTk3MjU4NiwiaWF0IjoxNDkzMzgwNTg2LCJlbWFpbCI6ImNoYW5kYW4uc2hhbmJoYWdAbWV0cmljc3RyZWFtLmNvbSIsImp0aSI6ImJkNmRkZDdiLWU1MWQtNGIxNy1iYjIzLWQyMjA2YzNlMTg5NCJ9.BOC8p_BWf29t2q4lQRiFCPSMJXLrfvht6KJBvu8e3NI8Lb4KtAwmNypb78J1ENtH2v_pjJF9jJ-yuycwf0iI90WmfNPl9TpT7pSw7GYQcBn_xmVLWrQNuIrSRd6HiSK8B9ARxrGaa-ag6QNPntmggzf9JZkeLmvMYIwZ3bdL7R6dEdEYv9Jq5ggl3urkAe4fuI8pZ0uGP53m193NPwUWhUU3G1Bv0p1khHSBl1TWdNujyNmubqgreL0FvrS243KsysObqM2v77HBdqfHhLq55wAVxUJPIQVTQA9y-PFn5cPIB58DuVM5HsrRTB0qLUet0KYySteMBMAsPcoF5bQGUA; studio.crowd.tokenkey=e3Qy8C4cswvhUwixtCCtCA00; JSESSIONID=967ADB97EDC0192FE7F83EC882065447; atlassian.xsrf.token=B45L-EXPQ-I1F1-VUDX|bdbc6d6a91fec3fda63d9f50e44fe4b6845549eb|lin; __utmb=251861909.1.10.1493380597; __utmc=251861909; __utmt=1";
        String connection="keep-alive";     
        RestAssured.baseURI="https://metricstreampm.atlassian.net:443/";
        RestAssured.port=2345;
        RestAssured.basePath="/rest/api/2/search/";
        int len=0;
      
        
        RequestSpecBuilder req=new RequestSpecBuilder();
        Map<String, String> cooky = new HashMap<String, String>() ;
        cooky.put("Cookie", cookie);
        
        req.addHeader("Accept", accept);
        req.addHeader("Cookie",cookie);
        req.addHeader("Connection", connection);
        RequestSpecification reqspec=req.build();
        Response r;
        String temp=id.toString();
        r=given().spec(reqspec).when().get("/?filter=-1&jql=issue in("+temp.substring(1, temp.length()-1)+")&fields=status,summary,issuetype,project,priority,resolution,customfield_10300&maxResults=5000");
          String resolution;
          try{
         len=JsonPath.read(r.asString(),"$.total");
          }catch(PathNotFoundException e){
          len=0;
          
          
          }
        for(int i=0;i<len;i++){
             try{
              
                String issue_type=JsonPath.read(r.asString(),"$.issues["+i+"].fields.issuetype.name");
                String issue_key=JsonPath.read(r.asString(),"$.issues["+i+"].key");
                String project_name=JsonPath.read(r.asString(),"$.issues["+i+"].fields.project.name");
                String priority=JsonPath.read(r.asString(),"$.issues["+i+"].fields.priority.name");
                String severity=JsonPath.read(r.asString(),"$.issues["+i+"].fields.customfield_10300.value");
                resolution=JsonPath.read(r.asString(),"$.issues["+i+"].fields.resolution.name");
                String status=JsonPath.read(r.asString(),"$.issues["+i+"].fields.status.name");
                String summary=JsonPath.read(r.asString(),"$.issues["+i+"].fields.summary");
                bugList b =new bugList(issue_type, issue_key, project_name, priority, severity, resolution, status, summary);
                buglist.add(b);
               }catch(PathNotFoundException e){
                    try{
                resolution="Unresolved";
                String issue_type=JsonPath.read(r.asString(),"$.issues["+i+"].fields.issuetype.name");
                String issue_key=JsonPath.read(r.asString(),"$.issues["+i+"].key");
                String project_name=JsonPath.read(r.asString(),"$.issues["+i+"].fields.project.name");
                String priority=JsonPath.read(r.asString(),"$.issues["+i+"].fields.priority.name");
                String severity=JsonPath.read(r.asString(),"$.issues["+i+"].fields.customfield_10300.value");
                //resolution=JsonPath.read(r.asString(),"$.issues["+i+"].fields.resolution.name");
                String status=JsonPath.read(r.asString(),"$.issues["+i+"].fields.status.name");
                String summary=JsonPath.read(r.asString(),"$.issues["+i+"].fields.summary");
                bugList b =new bugList(issue_type, issue_key, project_name, priority, severity, resolution, status, summary);
                buglist.add(b);
                    }catch(PathNotFoundException ea){
                    resolution="Unresolved";
                String issue_type=JsonPath.read(r.asString(),"$.issues["+i+"].fields.issuetype.name");
                String issue_key=JsonPath.read(r.asString(),"$.issues["+i+"].key");
                String project_name=JsonPath.read(r.asString(),"$.issues["+i+"].fields.project.name");
                String priority=JsonPath.read(r.asString(),"$.issues["+i+"].fields.priority.name");
                String severity="Severity Not Found";
                //resolution=JsonPath.read(r.asString(),"$.issues["+i+"].fields.resolution.name");
                String status=JsonPath.read(r.asString(),"$.issues["+i+"].fields.status.name");
                String summary=JsonPath.read(r.asString(),"$.issues["+i+"].fields.summary");
                bugList b =new bugList(issue_type, issue_key, project_name, priority, severity, resolution, status, summary);
                buglist.add(b);
                    }
                
                
                }
               
        }
        return buglist;
       
    }
}
