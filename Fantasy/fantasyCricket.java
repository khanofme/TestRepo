import java.util.*;
import java.io.*;
class fantasyCricket{
    Scanner sc;
    public static void main(String[] args)throws IOException {
        fantasyCricket fc=new fantasyCricket();
        FileWriter fw =new FileWriter("new1.txt");
        List<String> batsManList = new ArrayList<>();
        batsManList.add("Prabhsimran");
        // batsManList.add("Yashasvi");
        batsManList.add("Shikhar ");
        // batsManList.add("Butler");
        batsManList.add("Rajapakshe");
        // batsManList.add("Samson");
        batsManList.add("Livingston");
        // batsManList.add("Root");
        List<String> allRounderList = new ArrayList<>();
        
        
        List<String> wicketKeeperList = new ArrayList<>();
       

        List<String> bowlerList = new ArrayList<>(); 
        // bowlerList.add("T Deshpande");
        // bowlerList.add("Ishant Sharma");
        // bowlerList.add("M Pathirana");
       
        // // To Input BatsMen
        // fc.getData(batsManList,"BatsMan");
        // // To Input AllRounders
        // fc.getData(allRounderList,"AllRounders");
        // //To Input WicketKeepers 
        // fc.getData(wicketKeeperList,"WicketKeepers");
        // //To Input Bowlers
        // fc.getData(bowlerList, "Bowlers");

        //To Display the Players in added List
        fc.showData(batsManList,"BatsMen");
        fc.showData(allRounderList,"AllRounders");
        fc.showData(wicketKeeperList,"WicketKeepers");
        fc.showData(bowlerList,"Bowlers");
        List<String> players=new ArrayList<>();
        players.addAll(batsManList);
        players.addAll(allRounderList);
        players.addAll(wicketKeeperList);
        players.addAll(bowlerList);
        System.out.println("----------------------------------");
        fc.showData(players,"Players");

       
        Set<List<String>> allTeams=fc.createAllTeams(players,3);
        int i=1;
        for(List<String> list:allTeams){
           String text="Team "+i;
            fw.write(text+"\n");
            fw.write(list+"\n");
            i++;
        }
        fw.close();

        
        
    }

    public void getData(List<String> list, String type){
        sc=new Scanner(System.in); 
        System.out.println("Enter All the "+type+" in the List");
        char ch='N';
        do{
            String data=sc.nextLine();
            list.add(data);
            System.out.println("Press 'Y' or 'y' to Add another "+type);
            ch=sc.next().charAt(0);
            sc.nextLine();
        }while(ch=='Y'||ch=='y');
        System.out.println("Players are added to "+type+" List Successfully");
    }

    public void showData(List<String> list, String type){
        int i=1;
        System.out.println(type+" List");
        System.out.println("---------------------------");
        for(String player:list){
            System.out.println("\n "+i+". "+player);
            i++;
        }
    }

    public Set<List<String>> createAllTeams(List<String> players,int n){

        Set<List<String>> subarrays = new HashSet<>();
        String playrs[] = players.toArray(new String[players.size()]);
 
        findCombinations(playrs, 0, n, subarrays, new ArrayList<>());
        return subarrays;
    }
    

    public static void findCombinations(String[] A, int i, int k,
                                        Set<List<String>> subarrays,
                                        List<String> out)
    {
        // invalid input
        if (A.length == 0 || k > A.length) {
            return;
        }
 
        // base case: combination size is `k`
        if (k == 0) {
            subarrays.add(new ArrayList<>(out));
            return;
        }
 
        // start from the next index till the last index
        for (int j = i; j < A.length; j++)
        {
            // add current element `A[j]` to the solution and recur for next index
            // `j+1` with one less element `k-1`
            out.add(A[j]);
            findCombinations(A, j + 1, k - 1, subarrays, out);
            out.remove(out.size() - 1);        // backtrack
        }
    }

}