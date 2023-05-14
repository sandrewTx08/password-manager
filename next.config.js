/** @type {import('next').NextConfig} */
const nextConfig = {
  output: "export",
  distDir: "src/main/resources/public",
  eslint: { ignoreDuringBuilds: true },
};

module.exports = nextConfig;
