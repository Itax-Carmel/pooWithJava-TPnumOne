import java.util.Scanner;

class TPnumOne {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // Je fais appel aux méthodes ici
    noteDesCours(scanner);

    scanner.close();
  }

  static void noteDesCours(Scanner scanner) {
    int numDesCours;
    //Utilisation de la boucle do...while pour vérifier l'entré du user et s'assurer qu'il entre une valeur comprise entre 0 et 20
    do {
      String message = "Veuillez saisir le nombre de cours d'un étudiant";
      System.out.println(message);
      numDesCours = scanner.nextInt();
      if(numDesCours < 0 || numDesCours > 20){
        message = "Veuillez saisir une valeur comprise entre 0 et 20 svp!";
        System.out.println(message);
      }
    } while (numDesCours < 0 || numDesCours > 20);
    //Affectation de value aux Arrays resultInterro et coefDuCour ayant des length la valeur de numDesCours
    int resultInterro [] = new int[numDesCours];
    int coefDuCour []= new int[numDesCours];
    //Parcour du tableau "coefficient de cours"
    for(int i = 0; i < coefDuCour.length; i++){
      //Utilisation de la boucle do...while pour vérifier l'entré du user et s'assurer qu'il entre une valeur comprise entre 1 et 6 pour la pondération de cours
      do{
        String message = "Veuillez saisir la pondération du cours N°";
        System.out.println(message + (i + 1));
      coefDuCour[i] = scanner.nextInt();
        if(coefDuCour[i] < 1 || coefDuCour[i] > 6){
          message = "Veuillez saisir une valeur comprise entre 1 et 6 svp!";
          System.out.println(message);
        }
      } while(coefDuCour[i] < 1 || coefDuCour[i] > 6);
    }
    //On suppose que le user entre aussi les résultats des interros de l'étudiant
    for(int i = 0; i < resultInterro.length; i++){
      //Utilisation de la boucle do...while pour vérifier l'entré du user et s'assurer qu'il entre une valeur comprise entre 0 et 20 pour les résultats des interros
      do{
        String message = "Veuillez saisir la note de l'interro du cours N°";
        System.out.println(message + (i + 1));
      resultInterro[i] = scanner.nextInt();
        if(resultInterro[i] < 0 || resultInterro[i] > 20){
          message = "Veuillez saisir une valeur comprise entre 0 et 20 svp!";
          System.out.println(message);
        }
      } while(resultInterro[i] < 0 || resultInterro[i] > 20);
    }
    
    //Calcul de la moyenne pondérée
    int resultPonderee = 0;
    int moyPonderee;
    for (int i = 0, j = 0; i < resultInterro.length && j < coefDuCour.length; i++, j++) {
      //Récupération des notes pondérées
      resultPonderee = resultPonderee + (resultInterro[i] * coefDuCour[j]);
    };
    moyPonderee = resultPonderee / resultInterro.length;
    System.out.println("La moyenne pondérée obtenu par cet étudiant est: " + moyPonderee);

    //l'écart type
    /*S = V s² => s² = (resultInterro - moyPonderee)²---s² = variance*/
    int variance []= new int[numDesCours];
    for(int i = 0; i < resultInterro.length; i++){
      variance[i] = (resultInterro[i] - moyPonderee);
    }
    int ecartTypeCarree = 0;
    int ecartType = 0;
    for(int i = 0; i < variance.length; i++){
      ecartTypeCarree = ecartTypeCarree + (Math.pow((variance[i] - moyPonderee), 2));
    }
    ecartType = Math.sqrt(ecartTypeCarree);
    System.out.println("L'ecart type obtenu par cet étudiant est: " + ecartType);
    //le coefficient de variation pour les résultats obtenus
    /*CV = S / moyPonderee*/
    int cv = (ecartType / moyPonderee) * 100;
    if(cv > 30){
      System.out.println("Forte dispersion: " + cv + "%");
    }else if(cv >= 15 || cv <= 30){
      System.out.println("Forte dispersion: " + cv + "%");
    }else{
      System.out.println("Très faible dispersion: " + cv + "%");
    }
  }
}