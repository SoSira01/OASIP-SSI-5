module.exports = {
  content: ["./index.html", "./src/**/*.{vue,js,ts,jsx,tsx}"],
  theme: {
    extend: {},
  },
  daisyui: {
    themes: [
      {
        mytheme: {
          primary: "#3488ef",

          secondary: "#25dd8a",

          accent: "#f7769f",

          neutral: "#2C223F",

          "base-100": "#313235",

          info: "#1FB7EA",

          success: "#74E2A9",

          warning: "#EFA52E",

          error: "#E91619",
        },
      },
    ],
  },
  plugins: [require("daisyui")],
};
