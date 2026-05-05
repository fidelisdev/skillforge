package com.skillforge.hero;

import com.skillforge.hero.domain.HeroLevel;
import com.skillforge.hero.domain.QuestRarity;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class HeroApplicationTests {

    @Test
    void heroLevelFromXp() {
        assertThat(HeroLevel.fromXp(0)).isEqualTo(HeroLevel.APPRENTICE);
        assertThat(HeroLevel.fromXp(999)).isEqualTo(HeroLevel.APPRENTICE);
        assertThat(HeroLevel.fromXp(1000)).isEqualTo(HeroLevel.JOURNEYMAN);
        assertThat(HeroLevel.fromXp(3000)).isEqualTo(HeroLevel.EXPERT);
        assertThat(HeroLevel.fromXp(8000)).isEqualTo(HeroLevel.MASTER);
    }

    @Test
    void heroLevelCanSeeQuests() {
        assertThat(HeroLevel.APPRENTICE.canSee(QuestRarity.COMMON)).isTrue();
        assertThat(HeroLevel.APPRENTICE.canSee(QuestRarity.RARE)).isFalse();
        assertThat(HeroLevel.JOURNEYMAN.canSee(QuestRarity.RARE)).isTrue();
        assertThat(HeroLevel.JOURNEYMAN.canSee(QuestRarity.EPIC)).isFalse();
        assertThat(HeroLevel.EXPERT.canSee(QuestRarity.EPIC)).isTrue();
        assertThat(HeroLevel.MASTER.canSee(QuestRarity.LEGENDARY)).isTrue();
    }
}