class BrowserHistory {

    Deque<String> currHistory;
    Deque<String> forwardHistory;
                      
    public BrowserHistory(String homepage) {
        currHistory = new ArrayDeque<>();
        forwardHistory = new ArrayDeque<>();

        //initially curr history me homepager bhi insert karna hai
        currHistory.push(homepage);
    }
    
    public void visit(String url) {
        currHistory.push(url);
        while(! forwardHistory.isEmpty()){
            forwardHistory.pop();
        }
    }
    
    public String back(int steps) {
        //homepage se back nahi karunga , rest normally back karunga
        while(steps != 0){
            if(currHistory.size() > 1){
                forwardHistory.push(currHistory.pop());
            }else{
                //we are in homepage back nahi kar sakta
                break;
            }
            steps--;
        }
        return currHistory.peek();
    }
    
    public String forward(int steps) {
        //agar forward history mai tab hai tab tak forward kar sakta hu
        while(steps != 0){
            if(forwardHistory.size() > 0){
                currHistory.push(forwardHistory.pop());
            }else{
                break;
            }
            steps--;
        }
        return currHistory.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */