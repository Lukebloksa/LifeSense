import { useClickAway } from "react-use";
import { useRef } from "react";
import { useState } from "react";
import { Squash as Hamburger } from "hamburger-react";
import { AnimatePresence, motion } from "framer-motion";
import { routes } from "../routes";

function BurgerButton() {
    const [isOpen, setOpen] = useState(false);

    return (
        <div className="lg:hidden ">
            <Hamburger toggled={isOpen} size={20} toggle={setOpen} />
        </div>
    );
}

export default BurgerButton();