var core = new Vue({
    el:'#core',
    data:{
        page:1,
        list:[],
        name:'',
        my_write:true
    },
    created() {
        this.initList();
        this.getName();
    },
   methods: {
        getName:function(){
            axios.get('/session')
                .then(function (response) {
                    console.log(response.data);
                    if(response.data !=''){
                        core.name = response.data.fullName;
                        core.my_write = false;
                    }else{
                        core.name = '未登录';
                    }
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        initList:function(){
            axios.get('/page', {
                params: {
                    pageNum: this.page,
                    pageSize:4
                }
            })
                .then(function (response) {
                    if(response.data==''){
                        core.page--;
                       // console.log(core.page)
                        alert("暂无更多数据！");

                        return;
                    }
                    console.log(response.data);
                    console.log(response.data)
                    core.list = response.data;
                    //console.log(list)
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
    v_content:function(data){
      window.open("/content?id="+data)
    },
       nextPage:function () {
           this.page++;
           this.initList();

       },
       previousPage:function () {
           if(this.page>1){
               this.page--;
               this.initList()
           }else{
               alert('搞事情？？？')
           }
       },
       write:function () {
           if(!this.my_write){
               window.location.href =("/editor")
           }else{
               alert('请先登录！')
           }
       },
       tologin:function () {
           window.location.href =("loginPage")
       }
   }
})