  
new Vue({
    el: '#clientComponent',
    created: function(){
        this.getClients()       
    },
    data: {
        clientsData: []
    },
    methods: {
        reloadData: function(endPointUrl){
            axios.get(endPointUrl).then(response => {
                this.clientsData = response.data;
            });
        },
        getClients: function(){
        	this.reloadData(getClientsUrl())
        },
        previousPage: function(){
        	this.reloadData(this.clientsData.previousPageUrl);
        },
      	nextPage: function(){
      		this.reloadData(this.clientsData.nextPageUrl);
      	}
    }
});