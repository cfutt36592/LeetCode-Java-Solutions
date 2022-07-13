class Solution {
    
    private void findConnectEmails(String email, Map<String, Set<String>> emailGraph, Set<String> seenEmail, List<String> currentAccount){
        if(seenEmail.contains(email))
            return;
        
        seenEmail.add(email);
        currentAccount.add(email);
        for(String connectedEmail: emailGraph.get(email)){
            findConnectEmails(connectedEmail, emailGraph, seenEmail, currentAccount);
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> mergedAccounts = new LinkedList<>();
        
        Map<String, String> emailNameMap = new HashMap<>();
        Map<String, Set<String>> emailGraph = new HashMap<>();
        
        for(List<String> account: accounts){
            String name = account.get(0);
            if(account.size() == 0){
                List<String> mergedAccount = new LinkedList<>();
                mergedAccount.add(name);
                mergedAccounts.add(mergedAccount);
                continue;
            }
            
            String firstEmail = account.get(1);
            emailNameMap.put(firstEmail, name);
            emailGraph.computeIfAbsent(firstEmail, k -> new HashSet<>());
            
            for(int i = 2; i<account.size(); i++){
                String email = account.get(i);
                emailNameMap.put(email, name);
                emailGraph.computeIfAbsent(email, k -> new HashSet<>());
                
                emailGraph.get(email).add(firstEmail);
                emailGraph.get(firstEmail).add(email);
            }
        }
        
        Set<String> seenEmail = new HashSet<>();
        for(String email: emailNameMap.keySet()){
            String name = emailNameMap.get(email);
            List<String> currentAccount = new LinkedList<>();
            if(seenEmail.contains(email))
                continue;
            findConnectEmails(email, emailGraph, seenEmail, currentAccount);
            Collections.sort(currentAccount);
            currentAccount.add(0, name);
            mergedAccounts.add(currentAccount);
        }
        return mergedAccounts;
    }
}
