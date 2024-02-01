#include <bits/stdc++.h>


int main(int argc, char** argv)
{
	std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

	int n, m;
	int num;

	std::unordered_set<int> setA;
	std::unordered_set<int> setB;
	std::unordered_set<int> setAns;

	std::cin >> n >> m;

	for (int i = 0; i < n; ++i){
		std::cin >> num;
		setA.insert(num);
	}

	for (int i = 0; i < m; ++i){
		std::cin >> num;
		setB.insert(num);
	}

	for (int e : setA){
		if (setB.find(e) == setB.end()){
			setAns.insert(e);
		}
	}

	for (int e : setB){
		if (setA.find(e) == setA.end()){
			setAns.insert(e);
		}
	}

	std::cout << setAns.size() << "\n";
	return 0;
}