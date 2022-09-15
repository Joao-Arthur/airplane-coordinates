module.exports = {
    env: {
        browser: true,
        es2021: true,
    },
    extends: [
        'eslint:recommended',
        'plugin:react/recommended',
        'plugin:jsx-a11y/recommended',
        'airbnb',
        'airbnb-typescript',
    ],
    parser: '@typescript-eslint/parser',
    parserOptions: {
        project: ['./tsconfig.json'],
        ecmaFeatures: {
            jsx: true,
        },
        ecmaVersion: 'latest',
        sourceType: 'module',
    },

    plugins: ['react', 'react-hooks', 'jsx-a11y', '@typescript-eslint'],
    rules: {
        'react-hooks/rules-of-hooks': 'error',
        'react-hooks/exhaustive-deps': 'error',
        'react/jsx-filename-extension': ['error', { extensions: ['.tsx'] }],
        'react/jsx-uses-react': 'off',
        'react/react-in-jsx-scope': 'off',
        'react/jsx-indent': ['error', 4],
        'react/jsx-indent-props': ['error', 4],
        'import/prefer-default-export': 'off',
        'import/no-default-export': 'error',
        '@typescript-eslint/naming-convention': [
            'error',
            {
                selector: 'variable',
                format: ['camelCase'],
            },
            {
                selector: 'function',
                format: ['camelCase', 'PascalCase'],
            },
        ],
        '@typescript-eslint/indent': ['error', 4],
        'arrow-parens': ['error', 'as-needed'],
        'operator-linebreak': [
            'error',
            'after',
            { overrides: { '?': 'before', ':': 'before' } },
        ],
        'no-implicit-globals': 'error',
        'default-case': 'off',
        'no-restricted-syntax': 'off',
        curly: ['error', 'multi'],
        'nonblock-statement-body-position': ['error', 'below']
    },
};
