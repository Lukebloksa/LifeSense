import styles from "./Navigation.module.css";
import lightLogo from "../../assets/logo/lifesense_logo_light-removebg-preview.png";
import { useState } from "react";
import DropdownMenu from "../ui/dropdownMenu/DropDownMenu.tsx";

function Navigation() {
  const [isOpen, setIsOpen] = useState(false);

  const toggleMenu = () => {
    setIsOpen((prev) => !prev);
  };

  return (
    <div className={styles.navigationContainer}>
      <div className={styles.navigationLogo}>
          <a href={"/dashboard"}>
              <img
                  src={lightLogo}
                  alt="LifeSense Logo"
                  className={styles.navigationLogoImage}
              />
          </a>
      </div>

      <div className={`${styles.navigationLinks} ${isOpen ? styles.linksVisible : ""}`}>
          <button
              className={`${styles.burgerButton} ${isOpen ? styles.open : ""}`}
              onClick={toggleMenu}
              aria-label="Toggle navigation"
              aria-expanded={isOpen}
            >
              <span className={styles.bar}></span>
              <span className={styles.bar}></span>
              <span className={styles.bar}></span>
            </button>
            <DropdownMenu />
      </div>
    </div>
  );
}

export default Navigation;