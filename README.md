# README #

Este projeto é uma interface em Java para acessar a API do IBPT de forma a obter os impostos aproximados para uso no ERP.

O objetivo inicial é o uso deste projeto nos ERPs Adempiere e iDempiere.

### Instalação no Adempiere ###

Para instalar este recurso no Adempiere, certifique-se que você está usando uma versão igual ou superior a **LBR-201705**. Em seguida [copie o pacote](https://bitbucket.org/kenos/org.kenos.ibpt/downloads/) **ibpt-X.X.jar** para o servidor do Adempiere, na pasta `/packages/kenos/lib/` da sua instalação do Adempiere.

Com os arquivos do pacote na pasta correta basta executar o `RUN_setup` ou `RUN_silentsetup` para que a instalação seja concluída.

### Configuração ###

Após a instalação, basta entrar na janela **Configurador do Sistema** e adicionar um novo registro com o nome `LBR_IBPT_API_KEY`, no campo chave insira a **chave da API** obtida no IBPT. O **Nível de Configuração** deverá **sempre** ser configurado como **Organização**, pois cada organização deverá ter a sua própria chave de acesso que é única para cada CNPJ.

### Como Usar ###

Com a configuração feita no passo anterior, basta executar o processo de **Importar Impostos via IBPT** e deixar marcada a opção **Obter dados online via API**.

### Como contribuir? ###

Você pode fazer um *fork* e depois solicitar a integração através de um *pull request*. Para conversar com os desenvolvedores use o fórum da Kenos.