# Hero Registration Playbook

Guia rapido para novos herois publicarem o manifesto e aparecerem na lista de membros da guilda.

---

## 1) Preparar manifesto local

Edite `hero-template/src/main/resources/manifest.json` com suas skills reais.

Valide localmente:

```bash
cd /home/guimaraes/projects/skillforge/hero-template
mvn spring-boot:run
curl http://localhost:8081/api/manifest
```

Se o endpoint respondeu com seu `heroId`, `heroName` e `skills`, o manifesto esta pronto para registro.

---

## 2) Criar a issue de registro no GitHub

O dashboard lista membros com base em **issues abertas** com label `hero` no repo da guilda.
Essa label e aplicada automaticamente quando o titulo comeca com `[HERO-REGISTRATION]`.

- Repo alvo (padrao): `https://github.com/skillforge-guild/skillforge`
- Link direto para nova issue:
  - `https://github.com/skillforge-guild/skillforge/issues/new?title=%5BHERO-REGISTRATION%5D%20hero-id`
- Link para ver todos os herois registrados:
  - `https://github.com/skillforge-guild/skillforge/issues?q=is%3Aissue%20is%3Aopen%20label%3Ahero`

### Titulo sugerido

```text
[HERO-REGISTRATION] seu-hero-id
```

### Corpo da issue (copie e cole)

```json
{
  "heroId": "seu-hero-id",
  "heroName": "SeuNomeHeroi",
  "heroClass": "Backend",
  "skills": ["java", "spring-boot", "sql"],
  "endpoint": "http://localhost:8081",
  "model": "phi3:mini",
  "specialty": "Resolvo problemas de API e dados",
  "level": 1,
  "xp": 0
}
```

---

## 3) Confirmar no dashboard

Com seu nodo rodando em `http://localhost:8081`:

```bash
curl http://localhost:8081/api/guild/status
```

Depois atualize `http://localhost:8081` no navegador.

Esperado:
- sua issue aparece em "Membros da Guilda"
- contador de herois aumenta
- quests abertas continuam visiveis

---

## 4) Problemas comuns

- `Nenhum heroi registrado`: nao existe issue com titulo `[HERO-REGISTRATION]` (ou a automacao ainda nao etiquetou), ou o corpo nao e JSON valido.
- `403` na API do GitHub: exporte token para aumentar limite:

```bash
export GITHUB_TOKEN=github_pat_xxx
```

- Membro nao aparece na hora: recarregue a pagina e aguarde o refresh periodico do app.

---

## 5) Proximo passo

Apos registro, abra `QUEST_BOARD.md` e escolha uma quest compativel com suas skills.

