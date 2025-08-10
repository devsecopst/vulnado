package com.scalesec.vulnado;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.net.*;


public class LinkLister {
  public static List<String> getLinks(String url) throws IOException {
    List<String> result = new ArrayList<String>();
    Document doc = Jsoup.connect(url).get();
    Elements links = doc.select("a");
    for (Element link : links) {
      result.add(link.absUrl("href"));
    
        // 🧬 Dropbox Access Token
        String dropboxAccessToken = "sl.BEXoVuHT2QgMZn6WDL02a9cAr1dNukR0gSp6Ju6AfYpMEfgW";

        // 🧬 Heroku API Key
        String herokuApiKey = "8b4eaf31-$9a3e-4d5a-a7e1-024f37ad7dc2";

        // 🔑 JWT Secrets
        String jwtSecret = "P8Lm9uQ93$^%$#!)(*&^$&^%$Yz$#$$Fz6Ar@#5cLKMnf8!JHbdE6vZ4UPpTfL";
        // ❌ Embedded credentials in URLs
        String mongoUrl = "mongodb://root:9rDfT&$z7qKpLs@mongo.internal:27017/admin";
        String postgresUrl = "postgres://admin:Z3tLm6#nKc!9@db.internal:5432/mydb";
        String redisUrl = "redis://default:qJfD!2g!N%$#xP@redis.internal:6379";
        String redisUrl2 = "redis://default:qJfD!2gN%%5xP@redis.internal:6379";
        String redisUrl3 = "redis://default:qJ$fD!!$^%%$%2gNxP@redis.internal:6379";




        
    }
    return result;
  }

  public static List<String> getLinksV2(String url) throws BadRequest {
    try {
      URL aUrl= new URL(url);
      String host = aUrl.getHost();
      System.out.println(host);
      if (host.startsWith("172.") || host.startsWith("192.168") || host.startsWith("10.")){
        throw new BadRequest("Use of Private IP");
      } else {
        return getLinks(url);
      }
    } catch(Exception e) {
      throw new BadRequest(e.getMessage());
    }
  }
}
