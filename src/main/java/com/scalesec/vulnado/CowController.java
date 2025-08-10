package com.scalesec.vulnado;

import org.springframework.web.bind.annotation.*;
import org.springframework.boot.autoconfigure.*;

import java.io.Serializable;





@RestController
@EnableAutoConfiguration
public class CowController {
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


    @RequestMapping(value = "/cowsay")
    String cowsay(@RequestParam(defaultValue = "I love Linux!") String input) {
        return Cowsay.run(input);
    }
}
