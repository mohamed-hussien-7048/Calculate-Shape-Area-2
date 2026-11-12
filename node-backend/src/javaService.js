
const { spawn } = require("child_process");
const path = require("path");

const JAVA_CLASSES_PATH = path.resolve(
    __dirname,
    "../../java-engine/out"
);

function calculateShape(input) {
    return new Promise((resolve, reject) => {

        const javaProcess = spawn("java", [
            "-cp",
            JAVA_CLASSES_PATH,
            "com.saqr.shapes.ApiMain"
        ]);

        let output = "";
        let errorOutput = "";

        javaProcess.stdout.on("data", (data) => {
            output += data.toString();
        });

        javaProcess.stderr.on("data", (data) => {
            errorOutput += data.toString();
        });

        javaProcess.on("error", (error) => {
            reject(new Error(`Java process error: ${error.message}`));
        });

        javaProcess.on("close", (code) => {

            if (code !== 0) {
                reject(new Error(errorOutput || "Java process failed."));
                return;
            }

            try {
                const result = JSON.parse(output);
                resolve(result);
            } catch {
                reject(new Error("Invalid JSON response from Java."));
            }
        });

        javaProcess.stdin.end(`${input}\n`);
    });
}

module.exports = {
    calculateShape
};
