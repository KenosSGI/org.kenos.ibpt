# README #

Este projeto é uma interface em Java para acessar a API do IBPT de forma a obter os impostos aproximados para uso no ERP.

O objetivo inicial é o uso deste projeto nos ERPs Adempiere e iDempiere.

### Instalação no Adempiere ###

Para instalar este recurso no Adempiere, certifique-se que você está usando uma versão igual ou superior a **LBR-201705**. Em seguida [copie o pacote](https://bitbucket.org/kenos/org.kenos.ibpt/downloads/) **ibpt-X.X.jar** para o servidor do Adempiere, na pasta `/packages/kenos/lib/` da sua instalação do Adempiere.

Com os arquivos do pacote na pasta correta basta executar o `RUN_setup` ou `RUN_silentsetup` para que a instalação seja concluída.

### Como contribuir? ###

Você pode fazer um *fork* e depois solicitar a integração através de um *pull request*. Para conversar com os desenvolvedores use o fórum da Kenos.