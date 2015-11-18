
activeMenu('homeAction','.homeTh');
activeMenu('login','.homeTh');

activeMenu('myTransactionsAction','.myConciliation');
activeMenu('myInvoicesAction','.myConciliation');

activeMenu('checkingAction','.myChecking');
activeMenu('budgetDetailsAction','.myChecking');

activeMenu('myBudgetsAction','.myBudgets');
activeMenu('myNewBudgetAction','.myBudgets');
activeMenu('editBudgetsAction','.myBudgets');

activeMenu('homeSuperAction','.homeSuper');
activeMenu('login','.homeSuper');

activeMenu('otherTransactionsAction','.conciliation');
activeMenu('otherInvoicesAction','.conciliation');

activeMenu('otherBudgetsAction','.otherBudgets');
activeMenu('checkBudgetsAction','.otherBudgets');
activeMenu('editEventAction','.otherBudgets');

activeMenu('checkingSuperAction','.checking');
activeMenu('budgetDetailsSuperAction','.checking');
activeMenu('otherNewBudgetAction','.checking');

activeMenu('redirectToUsers','.users');

activeMenu('companiesAction','.companies');

activeMenu('reportsAction','.reportsClient');

activeMenu('reportsSiValeAction','.reportsSivale');

activeMenu('downloadInvoicesAction','.donwloadInvoices');
activeMenu('redirectToMainUsers','.users');

function activeMenu(module, menuElement){
	var regExp = new RegExp(module, 'g');
	if(window.location.pathname.match(regExp)){
		if(module == 'login')
			$($(".side-nav li")[0]).addClass("active");
		else
			$(menuElement).addClass("active");
	}
}