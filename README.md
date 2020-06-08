# Progetto-Programmazione-a-Oggetti-Castellano-De-Santis
## UTILIZZO CORRETTO DELL PROGETTO
Il progetto è stato sviluppato utilizzando il sito open-source FACEBOOK FOR DEVELOPERS, una pagina web che permette agli sviluppatori e alle aziende di conoscere più in dettaglio i dati delle proprie pagine al fine di migliorare la propria visibilità e arrivare a più utenti possibili.
FACEBOOK FOR DEVELOPERS offre diverse API  (interfacce di programmazione di un'applicazione) utilizzabili da software di API development come Postman, per una gestione facilitata del codice della pagina in formato JSON.
In questo progetto il codice è stato poi elaborato tramite l’IDE di ECLIPSE in linguaggio java. Con l’utilizzo della Web Application Spring Boot è possibile lanciare il programma, sviluppato in Eclipse attraverso Postman, ed effettuare le seguenti richieste di GET e POST:
-	Ottenere elenco dei post pubblicati (GET)
-	Ottenere metadata dei post (GET)
-	Pubblicare un post preso casualmente da elenco di message predefiniti in un file, impostando la data di pubblicazione (POST). La data di pubblicazione deve essere scritta nel seguente formato “YYYY-MM-ddThh:mm:ss”
-	Ottenere delle statistiche sui contenuti dei post in formato JSON (GET)
-	Fare dei filtri sui post della pagina ottenendo l’elenco dei post in formato JSON(POST)
-	Integrazione del metodo precedente con l’aggiunta di statistiche sui post filtrati. (POST) 
![alt text](https://github.com/Rinocastellano/Progetto-Programmazione-a-Oggetti-Castellano-De-Santis/blob/rinoWorking/univpm.it.CastelDeSa.progettoOOP.%20Use%20Case%20Diagram.jpg)
## INIZIALIZZARE IL PROGRAMMA
Per poter iniziare è necessario avere un account “Facebook for developers” , generare il relativo access token della propria pagina con tutti i permessi (vedi https://developers.facebook.com/docs/pages/publishing/ ).Successivamente basterà creare un file dove inserire tutti i post randomici riga per riga, considerato il tipo di lettura eseguita dal programma.
Una volta clonata la repository nella propria ide, è necessario: 
-	inserire il proprio access token e l’id della propria pagina nell’url situato nella classe App (riga 21) e nella classe TemporizationPosting (riga 76)
-	cambiare il percorso file nella classe TemporizationPosting (riga 73)
In questo modo il programma ha a disposizione tutto il necessario . Dopo aver cliccato col tasto destro sul progetto e aver eseguito la Run as Spring Boot app sarà possibile, attraverso Postman, inserire le diverse richieste di get e post all’ url http://localhost:8080 .

## UTILIZZO DELLE RICHIESTE
Le seguenti tabelle indicano e spiegano tutte le possibili richieste da inserire su Postman
### RICHIESTE POSSIBILI
|TIPO|ROTTA|DESCRIZIONE|
|---|---|---|
|GET|	/post|	Richiesta elenco post pagina|
|GET	|/metadata|	Richiesta elenco metadata dei post della pagina|
|POST|	/schedule|	Postare su Facebook un post randomico a una certa data|
|GET|	/stat|	Richiesta statistiche sui contenuti dei post|
|POST|	/filter|	Eseguire un filtro sui post della pagina|
|POST|	/statFiltered|	Eseguire una statistica su elenco di post filtrato|

### TEMPORIZATION POSTING
È necessario l’inserimento della futura data di pubblicazione del post nel body secondo uno specifico formato. Una condizione fondamentale per la pubblicazione del post è la seguente: l’orario di pubblicazione deve essere almeno 4h dopo l’orario di pubblicazione dell’ultimo post. Di seguito un esempio:
*(nel body)*
*“2021-05-03T20:20:00”*
Il post, se l’orario rispetta le condizioni da noi imposte, sarà pubblicato il 3 maggio 2021 alle ore 20:20:00. Il contenuto del messaggio sarà scelto randomicamente dal file creato precedentemente. L’id non sarà disponibile fino a quando non verrà pubblicato online.
*NOTA: la data di pubblicazione va scritta in formato “text” in modo tale da facilitarne l’inserimento.*

### STATISTICHE POSSIBILI
Per chiamare le diverse statistiche basta aggiungere a seguito di localhost:8080 le relative stringhe nella colonna Inserimento.
Il valore della specifica “type” può essere scritto sia in lowercase che in Uppercase.
|Nome |operatore|	Inserimento	Descrizione|
|---|---|---|
|Avg	|/stat?type=Avg	|Valore medio numero caratteri per post|
|Max	|/stat?type=Max	|Valore massimo numero caratteri per post|
|Min	|/stat?type=Min	|Valore minimo numero caratteri per post|
|NumPost	|/stat?type=NumPost	|Numero post|
|PresMult	|/stat?type=PresMult	|Numero post con contenuto multimediale|

### FILTRI POSSIBILI
Per utilizzare i diversi filtri si hanno 3 casi differenti
-	/filter?type=and  per fare la and di due filtri diversi
-	/filter?type=or     per fare la or di due filtri diversi
- /filter?type=…    con qualsiasi stringa o carattere diversa dalle precedenti per utilizzare un singolo filtro, purchè non sia nullo
Tali stringhe andranno aggiunte a localhost:8080.
Inoltre sarà possibile con l’operatore “&” eseguire una determinata statistica dopo un filtraggio

È analogo l’inserimento della prima lettera minuscola.


|Nome operatore|	Body|	Descrizione, Filtro:|
|---|---|---|
|Gt	|{“Gt”:[“x”]}|	Post con numero caratteri maggiori di x(int)|
|Lt	|{ “Lt”:[“x”]}|	Post con numero di caratteri minori di x(int)|
|Bt	|{ “Bt”:[“x”,”y”]}|	Post con numero di caratteri tra x e y (int)|
|InMessage|	{ “InMessage”:[“stringa cercata”]}|	Post aventi nel message la stringa cercata|
|InMult|	{“InMult”:[“”]}|	Post aventi contenuto multimediale (contenutoIn stringa irrilevante)|
|NInMessage|	{“NInMessage”:[“stringa cercata”]}|	Post non aventi nel message la stringa inserita |
|NInMult|	{“NInMult”:[“”]}|	Post non aventi contenuto multimediale(contenuto in stringa irrilevante)|

## Diagrammi delle classi
### Package
![Alt text](https://github.com/Rinocastellano/Progetto-Programmazione-a-Oggetti-Castellano-De-Santis/blob/rinoWorking/Packages.jpg)
### App
![Alt text](https://github.com/Rinocastellano/Progetto-Programmazione-a-Oggetti-Castellano-De-Santis/blob/rinoWorking/app%20Class%20Diagram%20APP.jpg)
### Model
![Alt text](https://github.com/Rinocastellano/Progetto-Programmazione-a-Oggetti-Castellano-De-Santis/blob/rinoWorking/model%20Class%20Diagram.jpg)
### Service
![Alt text](https://github.com/Rinocastellano/Progetto-Programmazione-a-Oggetti-Castellano-De-Santis/blob/rinoWorking/service%20Class%20Diagram%20SERVICE.jpg)
### Stat
![Alt text](https://github.com/Rinocastellano/Progetto-Programmazione-a-Oggetti-Castellano-De-Santis/blob/rinoWorking/app%20Class%20DiagramSTAT1.jpg)
### Util
![Alt text](https://github.com/Rinocastellano/Progetto-Programmazione-a-Oggetti-Castellano-De-Santis/blob/rinoWorking/utill%20Class%20Diagram%20UTIL.jpg)
### Filter
![Alt text](https://github.com/Rinocastellano/Progetto-Programmazione-a-Oggetti-Castellano-De-Santis/blob/rinoWorking/filter%20Class%20Diagram%20FILTER.jpg)
### Exception
![Alt text](https://github.com/Rinocastellano/Progetto-Programmazione-a-Oggetti-Castellano-De-Santis/blob/rinoWorking/esceptions%20Class%20Diagram%20EXC.jpg)

## Diagrammi delle sequenze
### GET/post
![Alt text](https://github.com/Rinocastellano/Progetto-Programmazione-a-Oggetti-Castellano-De-Santis/blob/rinoWorking/univpm.it.CastelDeSa.progettoOOP.%20Sequence%20Diagram%20filter%20GET%20POST.jpg)
### GET/metadata
![Alt text](https://github.com/Rinocastellano/Progetto-Programmazione-a-Oggetti-Castellano-De-Santis/blob/rinoWorking/univpm.it.CastelDeSa.progettoOOP.%20Sequence%20Diagram%20GET%20METADATA.jpg)
### GET/stat
![Alt text](https://github.com/Rinocastellano/Progetto-Programmazione-a-Oggetti-Castellano-De-Santis/blob/rinoWorking/univpm.it.CastelDeSa.progettoOOP.%20Sequence%20Diagram%20GET%20METADATA.jpg)
### POST/schedule
![Alt text](https://github.com/Rinocastellano/Progetto-Programmazione-a-Oggetti-Castellano-De-Santis/blob/rinoWorking/univpm.it.CastelDeSa.progettoOOP.%20Sequence%20Diagram%20TEMP%20POST.jpg)
### POST/filter
![Alt text](https://github.com/Rinocastellano/Progetto-Programmazione-a-Oggetti-Castellano-De-Santis/blob/rinoWorking/univpm.it.CastelDeSa.progettoOOP.%20Sequence%20Diagram%20post%20filter1.jpg)
### POST/statFiltered
![Alt text](https://github.com/Rinocastellano/Progetto-Programmazione-a-Oggetti-Castellano-De-Santis/blob/rinoWorking/univpm.it.CastelDeSa.progettoOOP.%20Sequence%20Diagram%20filter%20with%20stat.jpg)

