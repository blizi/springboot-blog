new Vue({
    el:"#c_login",
    data:{
        name:'',
        password:'',
        fullName:'',
        email:'',
        city:'',
        address:'',
        re_name:'',
        re_password:'',
        re_psd:''
    },
    methods: {
        register:function(){
            if(this.re_name==''||this.re_psd==''||this.re_password==''||this.fullName==''||this.email==''||this.city==''||this.address==''){
                alert('请完整输入所有内容！')
            }else{
                if(this.re_password==this.re_psd){
                    axios.post('/user/register', {
                        name: this.re_name,
                        password: this.re_password,
                        fullName:this.fullName,
                        email:this.email,
                        city:this.city,
                        address:this.address
                    })
                        .then(function (response) {
                            console.log(response.data);
                            if(response.data==1){
                                window.location.href =('/login')
                            }else{
                                alert('注册失败,或许用户名已存在！')
                            }
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
                }else{
                    alert('检查两次密码是否一致！')
                }
            }
        },
      login:function(){
        axios.post('/user/login', {
            name: this.name,
            password: this.password
          })
          .then(function (response) {
            console.log(response.data);
            if(response.data==1){
                window.location.href = ('index')
            }else{
                alert('登录失败')
            }
          })
          .catch(function (error) {
            console.log(error);
          });
      }
    },

})