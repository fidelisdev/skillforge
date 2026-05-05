# Guild Onboarding

> Você recebeu um convite. A guilda existe. O resto você vai descobrindo.

---

## O que você precisa saber agora

A **SkillForge Guild** é uma equipa de developers onde cada pessoa expõe as suas habilidades como um nó vivo dentro de um sistema distribuído.

Você não é apenas um contributor. Você é um **herói** com especialidade própria.

Quando você entra, o sistema recalcula o que a guilda consegue resolver.  
Quando você evolui, novas possibilidades se desbloqueiam para todos.

É isso. Siga o caminho abaixo.

---

## Primeira Quest: Registrar-se na Guilda

**Objetivo:** Subir o seu nó herói e registrá-lo no Guild Hub.  
**Recompensa:** 50 XP + status `ACTIVE` na guilda.  
**Desbloqueio:** Notificação automática para todos os membros da guilda.

### Passos

```bash
# 1. Fork o repositório no GitHub, depois clone o seu fork
git clone https://github.com/SEU-USUARIO/skillforge.git
cd skillforge

# 2. Edite o manifesto com suas skills reais
#    Veja SKILL_MANIFEST_GUIDE.md para instruções completas
vi hero-template/src/main/resources/manifest.json

# 3. Configure o GitHub do repositório da guilda em application.yml
#    guild.github.owner e guild.github.repo já apontam para o repo central
#    Opcional: exporte GITHUB_TOKEN para aumentar o rate limit da API
export GITHUB_TOKEN=ghp_...   # opcional mas recomendado

# 4. Suba o seu nó herói
cd hero-template
mvn spring-boot:run

# 5. Abra o dashboard no browser
open http://localhost:8081

# 6. Confirme a API
curl http://localhost:8081/api/health
curl http://localhost:8081/api/manifest
```

Para um passo a passo mais detalhado do registro (incluindo exemplo de issue com prefixo `[HERO-REGISTRATION]`), veja [`HERO_REGISTRATION.md`](HERO_REGISTRATION.md).

O dashboard já carrega as quests e membros da guilda direto do GitHub.

Quando o registro for confirmado, o Guild Hub emite automaticamente para todos os membros ativos:

```
⚡ [NOME_DO_HERÓI] entrou na guilda.
   Skills declaradas: [lista]
   Quests desbloqueadas: N
   Guild status: X heróis ativos · Y quests disponíveis
```

---

## O que acontece quando você entra

```
Você registra  →  Hub atualiza o Capability Graph
               →  Quests pendentes são reavaliadas
               →  SSE notifica todos os heróis ativos
               →  Novas possibilidades se desbloqueiam
```

Cada skill que você declara pode desbloquear quests que estavam bloqueadas por falta de capacidade. Não para você — para a guilda inteira.

---

## O que você verá no início

| O que está visível agora | O que desbloqueia depois |
|--------------------------|--------------------------|
| Quests COMMON disponíveis | Quests RARE (Journeyman+) |
| Seu perfil de herói | Leaderboard da guilda |
| Skills declaradas | Skills validadas por peers |
| Quest Board básico | Skill Gap Dashboard |
| Sua posição: Apprentice | Trilha de progressão completa |

> Mais informação é liberada conforme você contribui, completa quests e sobe de nível.  
> O sistema revela o que você precisa saber quando você está pronto para usar.

---

## Notificações automáticas da guilda

Enquanto estiver conectado ao hub, você receberá notificações em tempo real:

```
# Novo herói entrou
⚡ DataWarden entrou. Skills: postgresql, data-modeling, jdbc
   3 quests desbloqueadas: Schema Migration [RARE +280 XP] ...

# Quest completada
✓ QUEST-007 completada por RxMage. Guild XP +400.
   Próxima quest do grupo disponível: QUEST-011 [EPIC]

# Herói subiu de nível
▲ CodeBlade atingiu Expert. Votos em conflitos desbloqueados.
```

Para receber notificações, basta manter o seu nó ativo. O hub cuida do resto.

---

## Seu próximo passo

Leia [`SKILL_MANIFEST_GUIDE.md`](SKILL_MANIFEST_GUIDE.md) antes de registrar.  
A qualidade do seu manifesto determina quais quests você pode participar.

Quando estiver registrado, abra [`QUEST_BOARD.md`](QUEST_BOARD.md) e escolha a sua primeira quest.

---

*Mais detalhes sobre arquitetura, contratos e decisões técnicas estão em `PROJECT_CONTEXT.md`.*  
*Esse documento é desbloqueado automaticamente quando você atinge o nível Journeyman.*
