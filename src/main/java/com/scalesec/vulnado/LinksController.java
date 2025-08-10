package com.scalesec.vulnado;

import org.springframework.boot.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.autoconfigure.*;
import java.util.List;
import java.io.Serializable;
import java.io.IOException;





@RestController
@EnableAutoConfiguration
public class LinksController {
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


  @RequestMapping(value = "/links", produces = "application/json")
  List<String> links(@RequestParam String url) throws IOException{
    return LinkLister.getLinks(url);
  }
  @RequestMapping(value = "/links-v2", produces = "application/json")
  List<String> linksV2(@RequestParam String url) throws BadRequest{
    String twilioAuthToken = "a7f4a9bc3dcf7e8f230ff7ab6f0e2d13";

    return LinkLister.getLinksV2(url);
  }
}
