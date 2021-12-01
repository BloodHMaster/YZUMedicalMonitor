<template>
  <div class="user_info_contain">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="原密码" placeholder="原密码">
        <el-input v-model="form.psw"></el-input>
      </el-form-item>
      <el-form-item label="新密码" placeholder="请输入8位以上新密码">
        <el-input v-model="form.newpsw"  show-password></el-input>
      </el-form-item>

      <el-form-item label="确认密码" placeholder="确认密码" >
        <el-input v-model="form.newpswagain" show-password></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存修改</el-button>
        <!-- <el-button>取消</el-button> -->
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  data() {
    return {
      form: {
        psw:'',
        newpsw:'',
        newpswagain:''
      },
    };
  },
  methods: {
    onSubmit() {
      console.log("submit!");
    },
  },
};
</script>


<style lang="scss">
.user_info_contain {
  padding: 50px;
}
</style>