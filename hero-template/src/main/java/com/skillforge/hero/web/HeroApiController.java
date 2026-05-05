package com.skillforge.hero.web;

import com.skillforge.hero.domain.HeroManifest;
import com.skillforge.hero.service.GuildService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HeroApiController {

    private final GuildService guild;
    private final long startTime = System.currentTimeMillis();

    public HeroApiController(GuildService guild) {
        this.guild = guild;
    }

    @GetMapping("/health")
    public Map<String, Object> health() {
        return Map.of(
                "heroId", guild.getManifest().heroId(),
                "status", "UP",
                "uptime", (System.currentTimeMillis() - startTime) / 1000,
                "timestamp", Instant.now().toString()
        );
    }

    @GetMapping("/manifest")
    public HeroManifest manifest() {
        return guild.getManifest();
    }

    @GetMapping("/guild/status")
    public Map<String, Object> guildStatus() {
        return Map.of(
                "heroes", guild.getMembers().size(),
                "openQuests", guild.getOpenQuestCount(),
                "completedQuests", guild.getCompletedQuestCount(),
                "heroLevel", guild.getHeroLevel().name(),
                "lastFetch", Instant.ofEpochMilli(guild.getLastFetchMs()).toString()
        );
    }

    @GetMapping("/solve")
    public ResponseEntity<Map<String, Object>> solve(@RequestParam(defaultValue = "") String logSnippet) {
        if (logSnippet.isEmpty()) {
            logSnippet = "java.lang.NullPointerException: Cannot invoke 'String.length()' because 'name' is null at com.skillforge.Service.execute(Service.java:15)";
        }

        // Aqui integrarei com o Ollama no futuro.
        // Por enquanto, vamos simular a inteligência:
        String suggestion = "Parece que a classe 'Service.java' tentou acessar um método em um objeto nulo.";

        return ResponseEntity.ok(Map.of(
                "heroId", guild.getManifest().heroId(),
                "analysis", suggestion,
                "status", "SUCCESS",
                "recommendedFix", "Verifique se a variável 'name' foi inicializada antes da linha 15."
        ));
    }
}