<template>
  <el-container>
    <el-header>
      <top-bar></top-bar>
    </el-header>
    <el-container>
      <el-main class="main_block">
        <div class="divbg">
          <div class="mcon" style="margin-top: 10px;text-align:center;margin:0 auto">
              <div class="kaiti center">
                <h1>{{chengyu_content.idiom}}</h1>
              </div>
              <hr>
             <p class="ind2" style="text-align: left;font-size: 20px;display: block">
               <span class="tip">拼音</span>
               {{chengyu_content.idiomPhonetic}}
             </p>
             <p class="ind2" style="text-align: left;font-size: 20px;display: block">
               <span class="tip">出处</span>
               {{chengyu_content.allusion}}
             </p>
            <p class="ind2" style="text-align: left;font-size: 20px">
              <span class="tip">示例</span>
              {{chengyu_content.example}}
            </p>
            <p class="ind2" style="text-align: left;font-size: 20px">
              <span class="tip">解释</span>
              {{chengyu_content.explanation}}
            </p>
            <p class="ind2" style="text-align: left;font-size: 20px">
              <span class="tip">语法</span>
              {{chengyu_content.grammar}}
            </p>
            <p class="ind2" style="text-align: left;font-size: 20px">
              <span class="tip">结构</span>
              {{chengyu_content.structure}}
            </p>
            <p class="ind2" style="text-align: left;font-size: 20px">
              <span class="tip">近义</span>
              {{chengyu_content.similar}}
            </p>
<!--            <span><a href="">aaa</a></span>-->
          </div>
        </div>

      </el-main>
    </el-container>
  </el-container>
</template>


<script>
export default {
  name: "chengyu_detailed",
  data(){
    return{
      chengyu_content:undefined
    }
  },
  created() {
    console.log(this.$route.query.id)
    // console.log(id)
    var id = this.$route.query.id
    var that = this;
    that.visible = true;
    this.axios({
      url:'/getIdiomById',
      method:'post',
      data:{
        id: id
      }
    }).then(
      function (response){
        console.log(response.data)
        that.chengyu_content = response.data;
      },
      function (err){
        console.log(err)
      }
    )

  }
}
</script>

<style scoped>

.main_block {
  height: 1000px;
  color: #333;
  font-size: 20px;
  line-height: 1.5;
  font-family: "Helvetica Neue",Helvetica,Arial,"PingFang SC","Hiragino Sans GB","Heiti SC","Microsoft YaHei","WenQuanYi Micro Hei",sans-serif;
}

.divbg{
  width: 100%;
  height: 100%;
  background-size: 100%;
  background-image: url("../assets/bg.jpg");
}

h1{
  font-size: 42px;
  font-weight: normal;
}

.mcon h1 {
  letter-spacing: 2px;
  text-indent: 2px;
}

.mcon{
  background-color: #ebeee9;
  padding: 50px;
  width: 35%;
  height: 90%;
}

.kaiti {
  font-family: Georgia,Baskerville,"Liberation Serif","Kaiti SC",STKaiti,"AR PL UKai CN","AR PL UKai HK","AR PL UKai TW","AR PL UKai TW MBE","AR PL KaitiM GB",KaiTi,KaiTi_GB2312,DFKai-SB,"TW\-Kai",serif;
}

.center{
  text-align: center;
}

p.ind2 {
  text-indent: -3em;
  margin-left: 3em;
}

p {
  line-height: 28px;
  font-size: 16px;
  margin: 12px 0 0;
  text-indent: 2em;
  word-wrap: break-word;
  zoom: 1;
}

.tip, a.tip {
  margin-right: 0.75em;
  color: #77744d;
  text-decoration: none;
  border: 0 !important;
}

</style>
