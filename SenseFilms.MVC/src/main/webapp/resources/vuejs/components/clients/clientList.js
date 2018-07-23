new Vue({
    el: '#clientComponent',
    created: function(){
        this.getClients()       
    },
    data: {
        pagedClients: []
    },
    methods: {
        reloadData: function(endPointUrl){
            axios.get(endPointUrl).then(response => {
                this.pagedClients = response.data;
            });
        },
        getClients: function(){
        	this.reloadData(getClientsUrl())
        },
        previousPage: function(){
        	this.reloadData(this.pagedClients.previousPageUrl);
        },
      	nextPage: function(){
      		this.reloadData(this.pagedClients.nextPageUrl);
      	},
      	loadPage: function(url){
      		this.reloadData(url);
      	}
    }
});