# FSEChess

Fundamentals of Software Engineering Exam
Fabio Cogliati - VR101306
University of Verona, Italy

Development of chess game using java with Swing libraries.

The entire project is implemented using MVC pattern.
ChessPiecesFactory class use factory pattern and generates a chess piece based on the passed parameter.

The project have move prediction feature: for the selected piece the program colors all the tiles that represent a legal move by taking in account if the move brings you to a chess position for your opponent.

Features not yet implemented:
- Castling
- En Passant
- Pieces Promotion
- Player vs IA

Documentation is generated using JavaDoc

The project have some JUnit test classes, they check the correct behaviour for Pawns, Queens and Knights moves and check the correct execution of two famous chek mate game: Fool's Mate Game and Scholar's Mate Game




-----------------------------------------------------Italian---------------------------------------------------------------




Alcune note sul progetto:

  Implementazioni aggiuntive rispetto alla specifica:
    Ho aggiunto la previsione delle mosse, quando si seleziona un pezzo vengono illuminate tutte le caselle
     dove quel pezzo si può spostare, tenendo bene in considerazione di non illuminare le caselle che portano
     a uno scatto per il giocatore che sta muovendo.
    Movimento iniziale di due caselle per i pedoni.
    JavaDoc dell'intero progetto.
    
  Non ho implementato:
    Arrocco.
    Presa al passante.
    Promozione dei pezzi.
    
L'intero progetto è stato realizato seguendo il pattern MVC.

I pezzi vengono instanziati attraverso una factory che in base al tipo e al colore passato genera il pezzo.

Le classi che derivano da ChessPiece potevano essere implementate usando lo strategy pattern creando due behaviour :
moveBehaviour e flyBehaviour. Ho deciso di non utilizzare tale pattern per la sempicità che avrebbero avuto le due classi che
avrebbero ereditato da flyBehaviour e per il fatto che non avrei mai riutilizzato due volte una classe derivata di moveBehaviour.
Le varie classi presentano quindi una ripetizione del metodo canFly() che però è minima (l'unica istruzione è un return false
o un return true).

Alcune classi di test JUnit create fanno dei test su alcune mosse dei pedoni, delle regine e dei cavalli.
La classe FamousMateTest esegue le mosse di due matti famosi (barbiere e imbecille) e controlla che portino allo scacco matto e che tutte le mosse eseguite siano legali.
