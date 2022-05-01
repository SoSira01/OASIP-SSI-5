const { defineConfig } = require('@vue/cli-service')

module.exports = defineConfig({
    transpileDependencies: true
})
module.exports = {
    "devServer": {
        "proxy": {
            "/api": {
                "target": 'http://localhost:8080',
                //"pathRewrite": { '^/api': '' },
                "changeOrigin": true,
                "secure": false
            },
        },
        port: 80,
    }
};