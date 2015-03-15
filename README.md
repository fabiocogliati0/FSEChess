# FSEChess
Esame di FSE
Fabio Cogliati - VR101306
Università di Verona

Alcune note sul progetto:

  Implementazioni aggiuntive rispetto alla specifica:
    -Ho aggiunto la previsione delle mosse, quando si seleziona un pezzo vengono illuminate tutte le caselle
     dove quel pezzo si può spostare, tenendo bene in considerazione di non illuminare le caselle che portano
     a uno scatto per il giocatore che sta muovendo
    -Movimento iniziale di due caselle per i pedoni
    -JavaDoc dell'intero progetto
    
  Non ho implementato:
    -Arrocco
    -Presa al passante
    -Promozione dei pezzi
    
L'intero progetto è stato realizato seguendo il pattern MVC    

I pezzi vengono instanziati attraverso una factory che in base al tipo e al colore passato genera il pezzo

Le classi che derivano da ChessPiece potevano essere implementate usando lo strategy pattern creando due behaviour :
moveBehaviour e flyBehaviour. Ho deciso di non utilizzare tale pattern per la sempicità che avrebbero avto le due classi che
avrebbero ereditato da flyBehaviour e per il fatto che non avrei mai riutilizzato due volte una classe derivata di moveBehaviour
Le varie classi presentano quindi una ripetizione del metodo canFly() che però è minima (l'unica istruzione è un return false
o un return true)
