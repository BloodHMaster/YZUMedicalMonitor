<template>
  <div class="login-container">
    <vue-particles
      color="#409EFF"
      :particleOpacity="0.7"
      :particlesNumber="60"
      shapeType="circle"
      :particleSize="6"
      linesColor="#409EFF"
      :linesWidth="1"
      :lineLinked="true"
      :lineOpacity="0.4"
      :linesDistance="150"
      :moveSpeed="3"
      :hoverEffect="true"
      hoverMode="grab"
      :clickEffect="true"
      clickMode="push"
    >
    </vue-particles>

    <el-form
      ref="loginForm"
      :model="loginForm"
      :rules="loginRules"
      class="login-form"
      auto-complete="on"
      label-position="left"
    >
      <div class="title-container">
        <h3 class="title">AI辅助诊断系统</h3>
      </div>

      <el-form-item prop="username">
        <span class="svg-container">
          <svg-icon icon-class="user" />
        </span>
        <el-input
          ref="username"
          v-model="loginForm.username"
          placeholder="用户名/邮箱"
          name="username"
          type="text"
          tabindex="1"
          auto-complete="on"
        />
      </el-form-item>

      <el-form-item prop="password">
        <span class="svg-container">
          <svg-icon icon-class="password" />
        </span>
        <el-input
          :key="passwordType"
          ref="password"
          v-model="loginForm.password"
          :type="passwordType"
          placeholder="请输入密码"
          name="password"
          tabindex="2"
          auto-complete="on"
          @keyup.enter.native="handleLogin"
        />
        <span class="show-pwd" @click="showPwd">
          <svg-icon
            :icon-class="passwordType === 'password' ? 'eye' : 'eye-open'"
          />
        </span>
      </el-form-item>

      <el-button
        :loading="loading"
        type="primary"
        style="width: 100%; margin-bottom: 30px"
        @click.native.prevent="handleLogin"
        >登陆</el-button
      >

      <div class="forget_registered_contain">
        <el-button type="text" @click="ForgetPasswordVisible = true"
          >忘记密码？</el-button
        >
        <el-button
          type="text"
          class="registered"
          @click="registerVisible = true"
          >点击注册</el-button
        >
      </div>
    </el-form>

    <el-dialog title="忘记密码" :visible.sync="ForgetPasswordVisible">
      <el-form :model="forgetPasswordForm" class="dialog_item">
        <el-form-item label="邮箱" :label-width="formLabelWidth">
          <el-input
            v-model="forgetPasswordForm.e_mail"
            autocomplete="off"
            placeholder="请输入邮箱账号"
          ></el-input>
        </el-form-item>
        <div style="display: flex">
          <el-form-item label="验证码" :label-width="formLabelWidth">
            <el-input
              v-model="forgetPasswordForm.varifycode"
              autocomplete="off"
              placeholder="请输入验证码"
            ></el-input>
          </el-form-item>
          <el-button
            slot="append"
            type="success"
            style="color: white; height: 47px; width: 120px"
            v-show="showTime"
            @click="sendEmail(forgetPasswordForm.e_mail)"
            >发送验证码</el-button
          >
          <el-button
            slot="append"
            type="info"
            style="color: white; height: 47px; width: 120px; margin-left: 0px"
            v-show="!showTime"
            >{{ sendTime }}秒</el-button
          >
        </div>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="ForgetPasswordVisible = false">取 消</el-button>
        <el-button type="primary" @click="ForgetPasswordVisible = false"
          >确 定</el-button
        >
      </div>
    </el-dialog>

    <el-dialog title="重置密码" :visible.sync="ResetPasswordVisible">
      <el-form :model="forgetPasswordForm" class="dialog_item">
        <el-form-item label="新密码" :label-width="formLabelWidth">
          <el-input
            v-model="forgetPasswordForm.e_mail"
            autocomplete="off"
            placeholder="请输入新密码"
          ></el-input>
        </el-form-item>

        <el-form-item label="确认密码" :label-width="formLabelWidth">
          <el-input
            v-model="forgetPasswordForm.e_mail"
            autocomplete="off"
            placeholder="请再次输入密码"
          ></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="ResetPasswordVisible = false">取 消</el-button>
        <el-button type="primary" @click="ResetPasswordVisible = false"
          >确 定</el-button
        >
      </div>
    </el-dialog>

    <el-dialog title="用户注册" :visible.sync="registerVisible">
      <el-form
        :model="form"
        label-width="100px"
        class="dialog_item"
        :rules="formrules"
        ref="form"
      >
        <el-form-item label="用户名" prop="userAccount">
          <el-input
            v-model="form.userAccount"
            autocomplete="off"
            placeholder="请输入用户名"
          ></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="userPassword">
          <el-input
            v-model="form.userPassword"
            placeholder="请输入登录密码"
            show-password
          ></el-input>
        </el-form-item>

        <el-form-item label="确认密码" prop="userPasswordAgain">
          <el-input
            v-model="form.userPasswordAgain"
            placeholder="请输入再次输入登录密码"
            show-password
          ></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="userEmail">
          <el-input
            v-model="form.userEmail"
            autocomplete="off"
            placeholder="请输入邮箱账号"
          ></el-input>
        </el-form-item>
        <div style="display: flex">
          <el-form-item label="验证码" prop="verifycode">
            <el-input
              v-model="form.verifycode"
              autocomplete="off"
              placeholder="请输入验证码"
            ></el-input>
          </el-form-item>
          <el-button
            slot="append"
            type="success"
            style="color: white; height: 47px; width: 120px"
            v-show="showTime"
            @click="sendEmail(form.userEmail)"
            >发送验证码</el-button
          >
          <el-button
            slot="append"
            type="info"
            style="color: white; height: 47px; width: 120px; margin-left: 0px"
            v-show="!showTime"
            >{{ sendTime }}秒</el-button
          >
        </div>
        <div style="color: red; text-align: center">{{ alertText }}</div>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="registerVisible = false">取 消</el-button>
        <el-button type="primary" @click="registerNow">确 定</el-button>
      </div>
    </el-dialog>
    <el-button :plain="true" @click="open2">成功</el-button>
  </div>
</template>

<script>
import { validUsername } from "@/utils/validate";
import { loginVerify } from "@/api/user";
import { register } from "@/api/user";
import qs from "qs";
import {sendEmail} from "@/api/email"

export default {
  name: "Login",
  data() {
    const validateUsername = (rule, value, callback) => {
      if (value.length < 6) {
        callback(new Error("Please enter the correct user name"));
      } else {
        callback();
      }
    };
    const validatePassword = (rule, value, callback) => {
      if (value.length < 6) {
        callback(new Error("The password can not be less than 6 digits"));
      } else {
        callback();
      }
    };
    const checkEmail = (rule, value, callback) => {
      const mailReg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
      if (!value) {
        return callback(new Error("邮箱不能为空"));
      }
      setTimeout(() => {
        if (mailReg.test(value)) {
          callback();
        } else {
          callback(new Error("请输入正确的邮箱格式"));
        }
      }, 100);
    };
    return {
      showTime: true /* 布尔值，通过v-show控制显示‘获取按钮’还是‘倒计时’ */,
      sendTime: "" /* 倒计时 计数器 */,
      timer: null,
      ResetPasswordVisible: false, //重置密码对话框
      ForgetPasswordVisible: false, // 忘记密码对话框
      registerVisible: false, // 注册对话框
      form: {
        userAccount: "",
        userPassword: "",
        userPasswordAgain: "",
        userEmail: "",
        verifycode: "",
      },
      alertText: "",
      formrules: {
        userAccount: [
          { required: true, message: "请输入用户账号", trigger: "blur" },
          { min: 6, message: "长度在不得少于6个字符", trigger: "blur" },
        ],
        userPassword: [
          { required: true, message: "请输入登录密码", trigger: "blur" },
          { min: 6, message: "长度在不得少于6个字符", trigger: "blur" },
        ],
        userPasswordAgain: [
          { required: true, message: "请再次输出登录密码", trigger: "blur" },
          { min: 6, message: "长度在不得少于6个字符", trigger: "blur" },
        ],
        userEmail: [{ validator: checkEmail, trigger: "blur" }],
        verifycode: [
          { required: true, message: "请输入验证码", trigger: "blur" },
          { max: 6, message: "长度在不得大于6个字符", trigger: "blur" },
        ],
      },
      formLabelWidth: "120px",
      forgetPasswordForm: {
        e_mail: "",
        varifycode: "",
      },
      loginForm: {
        username: "",
        password: "",
      },
      loginRules: {
        username: [
          { required: true, trigger: "blur", validator: validateUsername },
        ],
        password: [
          { required: true, trigger: "blur", validator: validatePassword },
        ],
      },
      loading: false,
      passwordType: "password",
      redirect: undefined,
    };
  },
  watch: {
    $route: {
      handler: function (route) {
        this.redirect = route.query && route.query.redirect;
      },
      immediate: true,
    },
  },
  methods: {
    open2(messageinfo) {
      this.$message({
        message: messageinfo,
        type: "success",
      });
    },
    /**
     * 注册
     */
    registerNow() {
      this.$refs.form.validate((valid) => {
        if (valid) {
          if (this.form.userPassword != this.form.userPasswordAgain) {
            this.alertText = "两次密码不一致";
          } else {
            var registdata = qs.stringify({
              userAccount: this.form.userAccount,
              userNickName: this.form.userAccount, //默认是相同的,后期userNickName可以更改，但是userAccount不可更改
              userPassword: this.form.userPassword,
              userEmail: this.form.userEmail,
              verifycode: this.form.verifycode,
            });
            this.loading = true;
            register(registdata)
              .then((response) => {
                console.log(response);
                this.open2("注册成功");
                this.registerVisible = false;
              })
              .catch(() => {
                this.loading = false;
              });
          }
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    /*发送验证码时，开始计数，一分钟发送一次*/
    sendEmail(Email) {
      sendEmail({emailAddress:Email})
        .then((response) => {
          this.open2("发送成功");
        })
        .catch(() => {
          this.loading = false;
        });

      const TIME_COUNT = 60; //  更改倒计时时间
      if (!this.timer) {
        this.sendTime = TIME_COUNT;
        this.showTime = false;
        this.timer = setInterval(() => {
          if (this.sendTime > 0 && this.sendTime <= TIME_COUNT) {
            this.sendTime--;
          } else {
            this.showTime = true;
            clearInterval(this.timer); // 清除定时器
            this.timer = null;
          }
        }, 1000);
      }
    },
    showPwd() {
      if (this.passwordType === "password") {
        this.passwordType = "";
      } else {
        this.passwordType = "password";
      }
      this.$nextTick(() => {
        this.$refs.password.focus();
      });
    },
    handleLogin() {
      this.$refs.loginForm.validate((valid) => {
        if (valid) {
          this.loading = true;
          this.$store
            .dispatch("user/login", this.loginForm)
            .then(() => {
              this.$router.push({ path: this.redirect || "/" });
              this.loading = false;
            })
            .catch(() => {
              this.loading = false;
            });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
  },
};
</script>

<style lang="scss">
.forget_registered_contain {
  text-align: right;
}
.registered {
  margin-left: auto;
  color: #82f715;
}
.dialog_item {
  .el-form-item {
    background: white !important;
    .el-input {
      border: 1px solid #dcdfe6 !important;

      height: 47px;
      width: 85%;
      input {
        color: #606266 !important;
        caret-color: #606266 !important;
      }
    }
  }
}
.el-dialog {
  display: flex;
  flex-direction: column;
  margin: 0 !important;
  position: absolute;
  top: 30%;
  left: 50%;
  width: 25%;
  transform: translate(-50%, -50%);
  /*height:600px;*/
  max-height: calc(100% - 30px);
  max-width: calc(100% - 30px);
  box-shadow: var(--tw-ring-offset-shadow, 0 0 #0000),
    var(--tw-ring-shadow, 0 0 #0000), var(--tw-shadow);
}
.el-dialog .el-dialog__body {
  flex: 1;
  overflow: auto;
}
#particles-js {
  width: 100%;
  height: calc(100% - 100px);
  position: absolute;
}
/* 修复input 背景不协调 和光标变色 */
/* Detail see https://github.com/PanJiaChen/vue-element-admin/pull/927 */

$bg: #283443;
$light_gray: #fff;
$cursor: #fff;

@supports (-webkit-mask: none) and (not (cater-color: $cursor)) {
  .login-container .el-input input {
    color: $cursor;
  }
}

/* reset element-ui css */
.login-container {
  .el-input {
    display: inline-block;
    height: 47px;
    width: 85%;

    input {
      background: transparent;
      border: 0px;
      -webkit-appearance: none;
      border-radius: 0px;
      padding: 12px 5px 12px 15px;
      color: $light_gray;
      height: 47px;
      caret-color: $cursor;

      &:-webkit-autofill {
        box-shadow: 0 0 0px 1000px $bg inset !important;
        -webkit-text-fill-color: $cursor !important;
      }
    }
  }

  .el-form-item {
    border: 1px solid rgba(255, 255, 255, 0.1);
    background: rgba(0, 0, 0, 0.1);
    border-radius: 5px;
    color: #454545;
  }
}
</style>

<style lang="scss" scoped>
$bg: #2d3a4b;
$dark_gray: #889aa4;
$light_gray: #eee;

.login-container {
  min-height: 100%;
  width: 100%;
  background-color: $bg;
  overflow: hidden;

  .login-form {
    position: relative;
    width: 520px;
    max-width: 100%;
    padding: 160px 35px 0;
    margin: 0 auto;
    overflow: hidden;
  }

  .tips {
    font-size: 14px;
    color: #fff;
    margin-bottom: 10px;

    span {
      &:first-of-type {
        margin-right: 16px;
      }
    }
  }

  .svg-container {
    padding: 6px 5px 6px 15px;
    color: $dark_gray;
    vertical-align: middle;
    width: 30px;
    display: inline-block;
  }

  .title-container {
    position: relative;

    .title {
      font-size: 26px;
      color: $light_gray;
      margin: 0px auto 40px auto;
      text-align: center;
      font-weight: bold;
    }
  }

  .show-pwd {
    position: absolute;
    right: 10px;
    top: 7px;
    font-size: 16px;
    color: $dark_gray;
    cursor: pointer;
    user-select: none;
  }
}
</style>
