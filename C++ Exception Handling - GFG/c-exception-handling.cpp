// { Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++

class Solution{
public:
    int maxValue(int A, int B){
        // code here
        try{
            if(B==0){
            throw -999999;
        }
        int sum,sub,mul,divi;
        sum=A+B;
        sub=A-B;
        mul=A*B;
        divi=A/B;
        if(sum>sub && sum>mul && sum>divi){
            throw sum;
        }else if(sub>mul && sub>divi){
            return sub;
        }else if(mul>divi){
            throw mul;
        }else{
            throw divi;
        }
        }catch (int value){
            return value;
        }
    }
};

// { Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int A,B;
        cin>>A>>B;
        
        Solution ob;
        int ans = ob.maxValue(A,B);
        if(ans == -999999)
            cout<<"inf\n";
        else
            cout<<ans<<"\n";
    }
    return 0;
}  // } Driver Code Ends