type props = {
    readonly title: string;
    readonly onClick: () => void;
}

export function Button({ title, onClick }: props) {
    return (
        <button className='w-full inline-block px-12 py-3 text-sm text-center font-medium text-white bg-indigo-600 border border-indigo-600 rounded active:text-indigo-500 hover:bg-transparent hover:text-indigo-600 focus:outline-none focus:ring'
            onClick={onClick}
        >
            {title}
        </button>
    );
}
