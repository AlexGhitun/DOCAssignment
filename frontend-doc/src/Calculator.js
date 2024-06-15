import React, { useState } from 'react';
import axios from 'axios';

const Calculator = () => {
  const [a, setA] = useState('');
  const [b, setB] = useState('');
  const [result, setResult] = useState(null);
  const [operation, setOperation] = useState('');

  const handleCalculation = async (op) => {
    try {
      const response = await axios.post(`http://localhost:8989/calculator/${op}`, {
        a: parseFloat(a),
        b: parseFloat(b)
      });
      setResult(response.data);
    } catch (error) {
      console.error("There was an error making the request!", error);
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    handleCalculation(operation);
  };

  return (
    <div>
      <h1>Simple Calculator</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label>
            A:
            <input type="number" value={a} onChange={(e) => setA(e.target.value)} required />
          </label>
        </div>
        <div>
          <label>
            B:
            <input type="number" value={b} onChange={(e) => setB(e.target.value)} required />
          </label>
        </div>
        <div>
          <label>
            Operation:
            <select value={operation} onChange={(e) => setOperation(e.target.value)} required>
              <option value="">Select Operation</option>
              <option value="sum">Sum</option>
              <option value="subtraction">Subtraction</option>
              <option value="multiplication">Multiplication</option>
              <option value="division">Division</option>
            </select>
          </label>
        </div>
        <button type="submit">Calculate</button>
      </form>
      {result !== null && (
        <div>
          <h2>Result: {result}</h2>
        </div>
      )}
    </div>
  );
};

export default Calculator;
