
const express = require("express");
const { calculateShape } = require("./javaService");
const path = require("path");
const app = express();
const PORT = 3000;

app.use(express.json());
app.use(express.static(path.join(__dirname, "../../frontend")));
app.get("/api/health", (req, res) => {
    res.status(200).json({
        success: true,
        message: "Shapes API is running."
    });
});

app.post("/api/shapes/calculate", async (req, res) => {

    try {
        const { type, radius, width, height } = req.body;

        let input;

        if (type === "circle") {
            input = `CIRCLE|${radius}`;
        } else if (type === "rectangle") {
            input = `RECTANGLE|${width}|${height}`;
        } else {
            return res.status(400).json({
                success: false,
                message: "Invalid shape type."
            });
        }

        const result = await calculateShape(input);

        res.status(200).json(result);

    } catch (error) {
        res.status(500).json({
            success: false,
            message: error.message
        });
    }
});

app.listen(PORT, () => {
    console.log(`Server running on http://localhost:${PORT}`);
});
