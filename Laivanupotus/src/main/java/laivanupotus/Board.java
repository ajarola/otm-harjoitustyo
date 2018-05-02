package laivanupotus;

import java.util.*;

/**
 * Luokka toimii pelilautana ja sill� on lista laudalle kuuluvista laivoista, taulukko niiden sijainneista sekä tieto pelaajasta,
 * jolle se kuuluu.
 * @author Aleksi
 */
public class Board {

    private ArrayList<Ship> shiplist;
    private int[][] board;
    private Player owner;

    public Board(int size, Player owner) {

        this.owner = owner;
        this.board = initializeArray(size);
        this.shiplist = new ArrayList();
    }

    
/**
 * Metodi suorittaa ampumatapahtuman. Se tarkastaa ensin onko annettu syöte laillinen,
 * ja sen jälkeen checkShipsForHits-metodin avulla tarkistaa onko osumaa tapahtunut.
 * osuman tapahtuessa kutsuu Player-luokan hit metodia, joka hoitaa pelaajan terveyspisteiden vähentämisen
 * Palauttaa true osuman tapahtuessa, false muuten.
 * @param   row Käyttäjän antama tai satunnaisesti tuotettu syöte, joka määrittää rivin jota ammutaan.
 * @param   column Käyttäjän antama tai satunnaisesti tuotettu syöte, joka määrittää sarakkeen jota ammutaan.
 * 
 * @see
 *
 * @return true tai false, riippuen siitä tapahtuiko osumaa.
 */   
    public boolean shoot(int row, int column) {

        if (row >= this.board.length || column >= this.board.length) {
            System.out.println("Invalid input (not an integer) or shot out of bounds.");
            return false;
        }
        if (checkShipsForHits(row, column) == true) {
            this.owner.hit();
            return true;
        } else {
            return false;
        }
    }

 /**
 * Metodi tulostaa pelilaudan merkkiesityksenä komentoriville, näyttäen myös laivojen sijainnit. Käytetään oman pelilaudan näyttämiseen
 * @see
 */  
    public void showOwnBoard() {
        int help = 0;
        System.out.println("\n");
        System.out.println("     0    1    2    3    4    5    6    7    8    9 \n");

        for (int i = 0; i < this.board.length; i++) {
            System.out.print(help + "    ");
            help++;
            for (int j = 0; j < this.board.length; j++) {
                if (this.board[i][j] == -1) {
                    System.out.print("~" + "    ");
                } else if (this.board[i][j] == 1) {
                    System.out.print("S" + "    ");
                } else if (this.board[i][j] == 2) {
                    System.out.print("X" + "    ");
                } else {
                    System.out.print("O" + "    ");
                }
            }
            System.out.println("\n");
        }

    }
 /**
 * Metodi tulostaa pelilaudan merkkiesityksen� komentoriville, piilottaen laivojen sijainnit. Käytetään vastustajan pelilaudan näyttämiseen
 * @see
 */  
    public void showOpponentBoard() {

        int help = 0;
        System.out.println("\n");
        System.out.println("     0    1    2    3    4    5    6    7    8    9 \n");

        for (int i = 0; i < this.board.length; i++) {
            System.out.print(help + "    ");
            help++;
            for (int j = 0; j < this.board.length; j++) {
                if (this.board[i][j] == -1 || this.board[i][j] == 1) {
                    System.out.print("~" + "    ");
                } else if (this.board[i][j] == 2) {
                    System.out.print("X" + "    ");
                } else {
                    System.out.print("O" + "    ");
                }
            }
            System.out.println("\n");
        }

    }

/**
 * Metodi luo pelilaudalle satunnaisesti sijoitellut 5 laivaa. Laivojen pituudet ja nimet on ennalta määrätty, mutta niiden sijainti arvotaan
 * arpomalla ensin laivan aloitusrivi ja -sarake sekä suunta johon se rakennetaan. Laiva rakennetaan laudalle addShipToBoard-metodin avulla.
 */      
    public void randomBoard() {

        Random shiplocator = new Random();

        int[] shiplengths = {5, 4, 3, 3, 2};
        String[] shipnames = {"Carrier", "Battleship", "Cruiser", "Submarine", "Destroyer"};
        int k = 0;

        while (k < shiplengths.length) {

            int bowrow = shiplocator.nextInt(10);
            int bowcolumn = shiplocator.nextInt(10);
            int direction = shiplocator.nextInt(4);

            if (direction == 0) {
                if (addShipToBoard(bowrow, bowcolumn, bowrow + shiplengths[k] - 1, bowcolumn, shipnames[k]) == true) {
                    k++;
                }
            } else if (direction == 1) {
                if (addShipToBoard(bowrow, bowcolumn, bowrow, bowcolumn + shiplengths[k] - 1, shipnames[k]) == true) {
                    k++;
                }
            } else if (direction == 2) {
                if (addShipToBoard(bowrow, bowcolumn, bowrow - shiplengths[k] + 1, bowcolumn, shipnames[k]) == true) {
                    k++;
                }
            } else {
                if (addShipToBoard(bowrow, bowcolumn, bowrow, bowcolumn - shiplengths[k] + 1, shipnames[k]) == true) {
                    k++;
                }
            }

        }

    }

    /**
 * Metodi suorittaa laivan lisäämisen pelilaudalle annetun alku- ja loppusijainnin perusteella. ensin tarkistetaan sijainnin
 * olevan pelilaudan sisällä. Sen jälkeen varmistetaan, että syöte on oikein muotoiltu ja käytetään sopivaa buildShip-metodia. tämän jälkeen tarkistetaan
 * vielä, ettei laiva ole päätymässä toisen päälle. Sen jälkeen merkitään laivan sijainti pelilaudalle ja tämän jälkeen suoritetaan laivan varsinainen luominen ja
 * sen oheistoimenpiteet.
 * @param   row1 Laivan aloitusrivi.
 * @param   column1 Laivan aloitussarake.
 * @param   row2 Laivan lopetusrivi.
 * @param   column2 Laivan lopetussarake.
 * @param   name Laivan nimi.
 * @see
 *
 * @return true tai false, riippuen siitä onnistuuko laivan luominen.
 */  
    public boolean addShipToBoard(int row1, int column1, int row2, int column2, String name) {

        if (row1 < 0 || column1 < 0 || row2 < 0 || column2 < 0 || row1 > this.board.length - 1 || column1 > this.board.length - 1 || row2 > this.board.length - 1 || column2 > this.board.length - 1) {
            return false;
        }
        if (row2 < row1) {
            int helper = row1;
            row1 = row2;
            row2 = helper;
        }

        if (column2 < column1) {
            int helper = column1;
            column1 = column2;
            column2 = helper;
        }

        int[][] position;
        int lenght;

        if (column1 == column2) {

            position = buildShipPositionRow(row1, row2, column1);
            lenght = row2 - row1 + 1;

        } else if (row1 == row2) {

            position = buildShipPositionColumn(row1, column1, column2);
            lenght = column2 - column1 + 1;

        } else {
            return false;
        }

        if (checkPositionLegality(position) == false) {
            return false;
        }

        shipLocationToBoard(position);

        this.shiplist.add(new Ship(lenght, position, name));
        this.owner.addLives(lenght);

        return true;
    }
/**
 * Metodi luo ja alustaa tietynkokoisen taulukon, jota käytetään laivojen sijainnin ja pelilaudan ilmentymänä.
 * @param   size Taulukon koko.
 * @see
 *
 * @return palauttaa luodun taulukon.
 */ 
    public int[][] initializeArray(int size) {

        int[][] array = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = -1;
            }
        }
        return array;
    }
/**
 * Metodi tallentaa laivan sijainnin pelilaudalle. Tämä tapahtuu muuttamalla taulukon lukuarvoja.
 * @param   position Taulukko, johon on merkitty pelilaudalle tuleva laivan sijainti.
 * @see
 */ 
    public void shipLocationToBoard(int[][] position) {

        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {

                if (position[i][j] == 1) {
                    this.board[i][j] = 1;
                }
            }
        }
    }
/**
 * Metodi tallentaa tarkistaa, onko annetussa sijainnissa jo laivaa.
 * @param   position Taulukko, johon on merkitty pelilaudalle tuleva laivan sijainti.
 * @see
 * @return true, jos laivan voi sijoittaa annettuun sijaintiin ja false jos ei.
 */ 
    public boolean checkPositionLegality(int[][] position) {

        for (int i = 0; i < position.length; i++) {
            for (int j = 0; j < position.length; j++) {
                if (position[i][j] == 1 && this.board[i][j] != -1) {
                    return false;
                }
            }
        }
        return true;
    }
/**
 * Metodi tekee laivalle sijainnin rakennettaessa laivaa vaakasuoraan ja palauttaa sen taulukkona.
 * @param   startRow aloitusrivi
 * @param   endRow lopetusrivi
 * @param   column sarake, jolla laiva sijaitsee
 * @see
 * @return palauttaa laivan sijainnin sisältävän taulukon
 */ 
    public int[][] buildShipPositionRow(int startRow, int endRow, int column) {

        int[][] position = initializeArray(this.board.length);

        while (startRow <= endRow) {
            position[startRow][column] = 1;
            startRow++;
        }
        return position;
    }
/**
 * Metodi tekee laivalle sijainnin rakennettaessa laivaa pystyssuoraan ja palauttaa sen taulukkona.
 * @param   row rivi, jolla laiva sijaitsee
 * @param   startColumn aloitussarake
 * @param   endColumn lopetussarake
 * @see
 * @return palauttaa laivan sijainnin sisältävän taulukon
 */ 
    public int[][] buildShipPositionColumn(int row, int startColumn, int endColumn) {

        int[][] position = initializeArray(this.board.length);

        while (startColumn <= endColumn) {
            position[row][startColumn] = 1;
            startColumn++;
        }
        return position;
    }
/**
 * Metodi tarkastaa käymällä pelilaudan laivat sisältävän listan läpi, että onko niistä joku
 * syötteenä annetuissa koordinaateissa. palauttaa true jos näin on.
 * @param   row rivi
 * @param   column sarake
 * @see
 * @return true jos sijainnissa on laiva, false jos ei.
 */ 
    public boolean checkShipsForHits(int row, int column) {

        for (Ship ship : this.shiplist) {
            if (ship.getPosition()[row][column] == 1) {
                this.board[row][column] = 2;
                ship.getPosition()[row][column] = -1;
                ship.hit();
                return true;
            }
        }
        if (this.board[row][column] != 2) {
            this.board[row][column] = 0;
        }
        return false;
    }

    public int[][] getBoard(){
        return this.board;
    }
    
    public List<Ship> getShiplist(){
        return this.shiplist;
    }
}
