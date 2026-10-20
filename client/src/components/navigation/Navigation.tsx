import styles from "./Navigation.module.css";
import lightLogo from "../../assets/logo/lifesense_logo_light-removebg-preview.png";
import { useState } from "react";

function Navigation() {
  const [isOpen, setIsOpen] = useState(false);

  const toggleMenu = () => {
    setIsOpen((prev) => !prev);
  };

  return (
    <div className={styles.navigationContainer}>
      <div className={styles.navigationLogo}>
        <img
          src={lightLogo}
          alt="LifeSense Logo"
          className={styles.navigationLogoImage}
        />
      </div>

      <div
        className={`${styles.navigationLinks} ${isOpen ? styles.linksVisible : ""}`}
      >
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
      </div>
    </div>
  );
}

export default Navigation;