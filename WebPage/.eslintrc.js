module.exports = {
  root: true,
  parserOptions: {
    parser: 'babel-eslint',
    sourceType: 'module'
  },
  env: {
    browser: true,
    node: true,
    es6: true,
  },
  extends: ['plugin:vue/recommended', 'eslint:recommended'],

  // add your custom rules here
  //it is base on https://github.com/vuejs/eslint-config-vue
  rules: {
    "vue/max-attributes-per-line": [2, {
      "singleline": 10,
      "multiline": {
        "max": 1,
        "allowFirstLine": false
      }
    }],
    "vue/singleline-html-element-content-newline": "off",
    "vue/multiline-html-element-content-newline":"off",
    "vue/name-property-casing": ["error", "PascalCase"],
    "vue/no-v-html": "off",
    'accessor-pairs': 2,
    'arrow-spacing': [2, {
      'before': true,
      'after': true
    }],
    'block-spacing': [2, 'always'],
    'brace-style': [2, '1tbs', {
      'allowSingleLine': true
    }],
    'camelcase': [0, {
      'properties': 'always'
    }],
    'comma-dangle': [2, 'never'],
    'comma-spacing': [2, {
      'before': false,
      'after': true
    }],
    'comma-style': [2, 'last'],
    'constructor-super': 2,
    'curly': [2, 'multi-line'],
    'dot-location': [2, 'property'],
    'eol-last': 2,
    'eqeqeq': ["error", "always", {"null": "ignore"}],
    'generator-star-spacing': [2, {
      'before': true,
      'after': true
    }],
    'handle-callback-err': [2, '^(err|error)$'],
    'indent': [2, 2, {
      'SwitchCase': 1
    }],
    'jsx-quotes': [2, 'prefer-single'],
    'key-spacing': [2, {
      'beforeColon': false,
      'afterColon': true
    }],
    'keyword-spacing': [2, {
      'before': true,
      'after': true
    }],
    'new-cap': [2, {
      'newIsCap': true,
      'capIsNew': false
    }],
    'new-parens': 0,
    'no-array-constructor': 0,
    'no-caller': 0,
    // 'no-console': 'off',
    'no-class-assign': 0,
    'no-cond-assign': 0,
    'no-const-assign': 0,
    'no-control-regex': 0,
    'no-delete-var': 0,
    'no-dupe-args': 0,
    'no-dupe-class-members': 0,
    'no-dupe-keys': 0,
    'no-duplicate-case': 0,
    'no-empty-character-class': 0,
    'no-empty-pattern': 0,
    'no-eval': 0,
    'no-ex-assign':0,
    'no-extend-native': 0,
    'no-extra-bind': 0,
    'no-extra-boolean-cast': 0,
    'no-extra-parens': [2, 'functions'],
    'no-fallthrough': 0,
    'no-floating-decimal': 0,
    'no-func-assign': 0,
    'no-implied-eval': 0,
    'no-inner-declarations': [2, 'functions'],
    'no-invalid-regexp': 0,
    'no-irregular-whitespace': 0,
    'no-iterator': 0,
    'no-label-var': 0,
    'no-labels': [2, {
      'allowLoop': false,
      'allowSwitch': false
    }],
    'no-lone-blocks': 0,
    'no-mixed-spaces-and-tabs': 0,
    'no-multi-spaces': 0,
    'no-multi-str': 0,
    'no-multiple-empty-lines': [2, {
      'max': 1
    }],
    'no-native-reassign': 0,
    'no-negated-in-lhs': 0,
    'no-new-object': 0,
    'no-new-require': 0,
    'no-new-symbol': 0,
    'no-new-wrappers': 0,
    'no-obj-calls': 0,
    'no-octal': 0,
    'no-octal-escape': 0,
    'no-path-concat': 0,
    'no-proto': 0,
    'no-redeclare': 0,
    'no-regex-spaces': 0,
    'no-return-assign': [2, 'except-parens'],
    'no-self-assign': 0,
    'no-self-compare': 0,
    'no-sequences': 0,
    'no-shadow-restricted-names': 0,
    'no-spaced-func': 0,
    'no-sparse-arrays':0,
    'no-this-before-super': 0,
    'no-throw-literal':0,
    'no-trailing-spaces': 0,
    'no-undef': 0,
    'no-undef-init': 0,
    'no-unexpected-multiline': 0,
    'no-unmodified-loop-condition': 0,
    'no-unneeded-ternary': [2, {
      'defaultAssignment': false
    }],
    'no-unreachable': 0,
    'no-unsafe-finally': 0,
    'no-unused-vars': [2, {
      'vars': 'all',
      'args': 'none'
    }],
    'no-useless-call': 2,
    'no-useless-computed-key': 2,
    'no-useless-constructor': 2,
    'no-useless-escape': 0,
    'no-whitespace-before-property': 2,
    'no-with': 2,
    'one-var': [2, {
      'initialized': 'never'
    }],
    'operator-linebreak': [2, 'after', {
      'overrides': {
        '?': 'before',
        ':': 'before'
      }
    }],
    'padded-blocks': [2, 'never'],
    'quotes': [2, 'single', {
      'avoidEscape': true,
      'allowTemplateLiterals': true
    }],
    'semi': [2, 'never'],
    'semi-spacing': [2, {
      'before': false,
      'after': true
    }],
    'space-before-blocks': [2, 'always'],
    // 'space-before-function-paren': [2, 'never'],
    'space-before-function-paren': 0,
    'space-in-parens': [2, 'never'],
    'space-infix-ops': 2,
    'space-unary-ops': [2, {
      'words': true,
      'nonwords': false
    }],
    'spaced-comment': [2, 'always', {
      'markers': ['global', 'globals', 'eslint', 'eslint-disable', '*package', '!', ',']
    }],
    'template-curly-spacing': [2, 'never'],
    'use-isnan': 2,
    'valid-typeof': 2,
    'wrap-iife': [2, 'any'],
    'yield-star-spacing': [2, 'both'],
    'yoda': [2, 'never'],
    'prefer-const': 2,
    // 'no-debugger': process.env.NODE_ENV === 'production' ? 2 : 0,
    'object-curly-spacing': [2, 'always', {
      objectsInObjects: false
    }],
    'array-bracket-spacing': [2, 'never']
  }
}
