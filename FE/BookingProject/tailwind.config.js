module.exports = {
  content: ["./index.html", "./src/**/*.{vue,js,ts,jsx,tsx}"],
  theme: {
    extend: {},
  },
  daisyui: {
    themes: [
      {
        mytheme: {
          primary: "#74d2ed",

          secondary: "#f28cc4",

          accent: "#9377ef",

          neutral: "#272230",

          "base-100": "#1c1917",

          info: "#3755EB",

          success: "#1FB769",

          warning: "#EFA639",

          error: "#E1374E",
        },
      },
    ],
  },
  plugins: [require("daisyui")],
};